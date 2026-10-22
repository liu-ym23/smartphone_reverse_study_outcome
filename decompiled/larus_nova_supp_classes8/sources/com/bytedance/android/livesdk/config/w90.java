package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w90 extends SSettingKey<Float> {
    public static final w90 a = null;

    static {
        a = new w90();
    }

    public w90() {
        Float r0 = Float.valueOf(0.1f);
        super("live_monitor_rtc_resolutio_redundancy_threshold", "pk及多人主播连线监控推流分辨率阈值", r0, r0);
    }
}
