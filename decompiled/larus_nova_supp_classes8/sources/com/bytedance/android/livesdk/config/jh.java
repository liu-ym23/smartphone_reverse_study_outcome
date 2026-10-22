package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jh extends SSettingKey<Boolean> {
    public static final jh a = null;

    static {
        a = new jh();
    }

    public jh() {
        Boolean r1 = Boolean.TRUE;
        super("live_broadcast_nonitor_report_trace", "主播监控是否上报trace", r1, r1);
    }
}
