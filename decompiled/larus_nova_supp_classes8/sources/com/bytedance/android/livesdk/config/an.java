package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class an extends SSettingKey<com.bytedance.android.livesdk.performance.u> {
    public static final an a = null;

    static {
        a = new an();
    }

    public an() {
        super("live_degrade_threshold_setting", "性能降级阈值配置", new com.bytedance.android.livesdk.performance.u(), new com.bytedance.android.livesdk.performance.u());
    }
}
