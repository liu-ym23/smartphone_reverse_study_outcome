package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q10 extends SSettingKey<Boolean> {
    public static final q10 a = null;

    static {
        a = new q10();
    }

    public q10() {
        Boolean r4 = Boolean.FALSE;
        super("live_inner_feed_loadmore_error_report_stack", "内流数据加载失败堆栈上报", r4, r4, true);
    }
}
