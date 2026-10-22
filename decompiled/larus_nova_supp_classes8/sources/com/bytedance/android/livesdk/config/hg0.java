package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hg0 extends SSettingKey<Boolean> {
    public static final hg0 a = null;

    static {
        a = new hg0();
    }

    public hg0() {
        Boolean r1 = Boolean.FALSE;
        super("live_perf_monitor_collect_full_gc", "性能埋点收集全量gc info", r1, r1);
    }
}
