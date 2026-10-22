package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sb extends SSettingKey<Long> {
    public static final sb a = null;

    static {
        a = new sb();
    }

    public sb() {
        super("live_anchor_exposure_log_gap_time", "曝光日志聚合时间", 3L, 3L);
    }
}
