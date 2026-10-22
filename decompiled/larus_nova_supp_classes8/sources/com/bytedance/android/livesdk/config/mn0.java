package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mn0 extends SSettingKey<com.bytedance.android.livesdk.performance.v0> {
    public static final mn0 a = null;

    static {
        a = new mn0();
        yu.a.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public mn0() {
        super("live_rig_hprof_setting", "直播上报hprof到rig配置", new com.bytedance.android.livesdk.performance.v0(), new com.bytedance.android.livesdk.performance.v0(), true);
    }
}
