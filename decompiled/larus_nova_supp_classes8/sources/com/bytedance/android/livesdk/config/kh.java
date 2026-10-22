package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class kh extends SSettingKey<Boolean> {
    public static final kh a = null;

    static {
        a = new kh();
    }

    public kh() {
        Boolean r1 = Boolean.TRUE;
        super("live_broadcast_nonitor_report_trace_sync", "主播监控是否异步上报trace", r1, r1);
    }
}
