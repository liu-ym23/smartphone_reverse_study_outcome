package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class di extends SSettingKey<Float> {
    public static final di a = null;

    static {
        a = new di();
    }

    public di() {
        Float r0 = Float.valueOf(8.0f);
        super("live_broadcast_stable_mode_bad_fps_threshold", "开播稳定模式性能差阈值", r0, r0);
    }
}
