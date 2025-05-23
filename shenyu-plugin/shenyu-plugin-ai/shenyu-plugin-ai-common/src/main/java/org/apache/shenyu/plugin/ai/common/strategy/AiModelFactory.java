/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shenyu.plugin.ai.common.strategy;

import org.apache.shenyu.common.enums.AiModelProviderEnum;
import org.apache.shenyu.plugin.ai.common.strategy.openai.OpenAI;

import java.util.Objects;

/**
 * The interface Ai model.
 */
public final class AiModelFactory {
    
    private AiModelFactory() {
    }

    /**
     * Create ai model instance.
     *
     * @param provider the provider
     * @return the ai model provider
     */
    public static AiModel createAiModel(final AiModelProviderEnum provider) {
        if (Objects.isNull(provider)) {
            throw new IllegalArgumentException("not supported provider");
        }
        return switch (provider) {
            case OPEN_AI, DEEP_SEEK, ALIYUN, OPEN_API, MOONSHOT -> new OpenAI();
        };
    }
}
