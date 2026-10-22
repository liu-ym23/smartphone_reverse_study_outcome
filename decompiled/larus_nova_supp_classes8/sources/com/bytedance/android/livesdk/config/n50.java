package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n50 extends SSettingKey<Boolean> {
    public static final n50 a = null;

    static {
        a = new n50();
    }

    public n50() {
        Boolean r1 = Boolean.TRUE;
        super("live_landscape_picture_scale_gesture_enabled", "横屏直播间手动放大拉伸能力开关", r1, r1);
    }
}
