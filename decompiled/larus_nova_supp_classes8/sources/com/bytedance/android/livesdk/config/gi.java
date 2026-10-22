package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gi extends SSettingKey<Float> {
    public static final gi a = null;

    static {
        a = new gi();
    }

    public gi() {
        Float r0 = Float.valueOf(13.0f);
        super("live_broadcast_stable_mode_risk_fps_threshold", "开播稳定模式性能存在低风险阈值", r0, r0);
    }
}
