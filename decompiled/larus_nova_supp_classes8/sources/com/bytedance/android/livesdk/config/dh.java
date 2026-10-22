package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dh extends SSettingKey<Boolean> {
    public static final dh a = null;

    static {
        a = new dh();
    }

    public dh() {
        Boolean r1 = Boolean.TRUE;
        super("live_broadcast_fix_anchor_perf_monitor", "主播性能监控bugfix", r1, r1);
    }
}
