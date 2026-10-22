package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hi extends SSettingKey<Integer> {
    public static final hi a = null;

    public hi() {
        super("live_broadcast_stable_mode_fps_count", "开播稳定模式低于阈值次数", 4, 4);
    }

    static {
        a = new hi();
    }
}
