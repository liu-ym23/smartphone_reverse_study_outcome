package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.AdaptiveGradingConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t9 extends SSettingKey<AdaptiveGradingConfig> {
    public static final t9 a = null;

    static {
        a = new t9();
    }

    public t9() {
        super("live_adaptive_grading_config", "智能图像增强配置", new AdaptiveGradingConfig(), new AdaptiveGradingConfig());
    }
}
