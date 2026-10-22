package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fq0 extends SSettingKey<Boolean> {
    public static final fq0 a = null;

    static {
        a = new fq0();
    }

    public fq0() {
        Boolean r1 = Boolean.FALSE;
        super("live_screencast_multi_device_enable", "录屏多设备直播开关", r1, r1);
    }
}
