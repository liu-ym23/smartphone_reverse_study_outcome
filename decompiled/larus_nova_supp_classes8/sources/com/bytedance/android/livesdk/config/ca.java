package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.config.ai.LiveAIConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ca extends SSettingKey<LiveAIConfig> {
    public static final ca a = null;

    static {
        a = new ca();
    }

    public ca() {
        super(LiveInitSettingKeys.LIVE_AI_CONFIG, "Client AI配置", new LiveAIConfig(), new LiveAIConfig());
    }
}
