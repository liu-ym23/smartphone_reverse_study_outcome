package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fi extends SSettingKey<Float> {
    public static final fi a = null;

    static {
        a = new fi();
    }

    public fi() {
        Float r0 = Float.valueOf(12.0f);
        super("live_broadcast_stable_mode_poor_fps_threshold", "开播稳定模式性能存在风险阈值", r0, r0);
    }
}
