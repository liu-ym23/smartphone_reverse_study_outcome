package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p00 extends SSettingKey<com.bytedance.android.livesdk.performance.o> {
    public static final p00 a = null;

    static {
        a = new p00();
    }

    public p00() {
        super("live_hprofdumpper_setting", "直播单点hprof dump", new com.bytedance.android.livesdk.performance.o(), new com.bytedance.android.livesdk.performance.o(), true);
    }
}
