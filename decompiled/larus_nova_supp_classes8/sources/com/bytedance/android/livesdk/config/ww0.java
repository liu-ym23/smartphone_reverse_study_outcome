package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ww0 extends SSettingKey<Float> {
    public static final ww0 a = null;

    static {
        a = new ww0();
    }

    public ww0() {
        Float r0 = Float.valueOf(0.25f);
        super("live_video_chorus_public_screen_height_ratio", "视频合唱手机公屏高度比", r0, r0);
    }
}
