package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class cv0 extends SSettingKey<Integer> {
    public static final cv0 a = null;

    static {
        a = new cv0();
    }

    public cv0() {
        super("live_toolbar_load_time_stats_sampling", "toolbar加载耗时统计采样率0-100000", 10, 10);
    }
}
