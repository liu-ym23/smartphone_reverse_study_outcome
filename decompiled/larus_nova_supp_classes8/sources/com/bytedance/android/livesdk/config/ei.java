package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ei extends SSettingKey<Float> {
    public static final ei a = null;

    static {
        a = new ei();
    }

    public ei() {
        Float r0 = Float.valueOf(15.0f);
        super("live_broadcast_stable_mode_good_fps_threshold", "开播稳定模式性能良好阈值", r0, r0);
    }
}
