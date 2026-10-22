package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.config.link.InteractFrequencyConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class yi1 extends SSettingKey<InteractFrequencyConfig> {
    public static final yi1 a = null;

    static {
        a = new yi1();
    }

    public yi1() {
        super("video_equal_switch_frequncy_config", "平权浮窗布局切换频控", new InteractFrequencyConfig(), new InteractFrequencyConfig());
    }
}
