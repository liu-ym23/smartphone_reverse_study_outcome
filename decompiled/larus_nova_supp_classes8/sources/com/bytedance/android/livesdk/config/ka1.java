package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ka1 extends SSettingKey<Boolean> {
    public static final ka1 a = null;

    static {
        a = new ka1();
    }

    public ka1() {
        super("live_revenue_interact_forward_stream_opt_enable", "跨房推流优化开关", Boolean.TRUE, Boolean.FALSE);
    }
}
