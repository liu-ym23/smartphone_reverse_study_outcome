package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class cg0 extends SSettingKey<Boolean> {
    public static final cg0 a = null;

    static {
        a = new cg0();
    }

    public cg0() {
        Boolean r1 = Boolean.TRUE;
        super("live_performance_stop_log", "直播性能停止埋点", r1, r1);
    }
}
