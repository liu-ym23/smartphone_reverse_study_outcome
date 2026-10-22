package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h50 extends SSettingKey<Boolean> {
    public static final h50 a = null;

    static {
        a = new h50();
    }

    public h50() {
        Boolean r1 = Boolean.TRUE;
        super("live_landscape_gesture_brightness_volume_enable", "横屏直播间手势调节音量亮度的开关", r1, r1);
    }
}
