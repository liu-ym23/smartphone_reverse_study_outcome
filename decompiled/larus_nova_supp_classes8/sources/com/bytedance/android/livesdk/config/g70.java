package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g70 extends SSettingKey<Boolean> {
    public static final g70 a = null;

    static {
        a = new g70();
    }

    public g70() {
        Boolean r1 = Boolean.FALSE;
        super("live_log_anr_optimize", "优化无用高频调用导致的ANR问题", r1, r1);
    }
}
