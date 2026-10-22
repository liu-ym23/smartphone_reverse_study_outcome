package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class yu extends SSettingKey<com.bytedance.android.livesdk.performance.j> {
    public static final yu a = null;

    static {
        yu r0 = new yu();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public yu() {
        super("live_eris_setting", "直播eris监控的设置", new com.bytedance.android.livesdk.performance.j(), new com.bytedance.android.livesdk.performance.j(), true);
    }
}
