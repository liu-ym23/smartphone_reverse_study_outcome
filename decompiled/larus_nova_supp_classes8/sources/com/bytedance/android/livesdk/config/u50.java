package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u50 extends SSettingKey<g51> {
    public static final u50 a = null;

    static {
        u50 r0 = new u50();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public u50() {
        super("live_light_feedback_config_v2", "满意度轻交互V2配置", new g51(), new g51());
    }
}
