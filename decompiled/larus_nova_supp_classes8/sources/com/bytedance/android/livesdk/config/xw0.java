package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xw0 extends SSettingKey<Float> {
    public static final xw0 a = null;

    static {
        a = new xw0();
    }

    public xw0() {
        Float r0 = Float.valueOf(0.15f);
        super("live_video_chorus_public_screen_height_ratio_pad", "视频合唱异形屏公屏高度比", r0, r0);
    }
}
