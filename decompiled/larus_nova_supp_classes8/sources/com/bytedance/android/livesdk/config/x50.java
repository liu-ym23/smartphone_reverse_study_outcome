package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x50 extends SSettingKey<j51> {
    public static final x50 a = null;

    static {
        x50 r0 = new x50();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public x50() {
        super("live_linkmic_dynamic_config", j51.class, "直播多人场景动态化配置", new j51(), new j51());
    }
}
