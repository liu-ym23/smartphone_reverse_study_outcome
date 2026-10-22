package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jc1 extends SSettingKey<Boolean> {
    public static final jc1 a = null;

    static {
        a = new jc1();
    }

    public jc1() {
        Boolean r1 = Boolean.TRUE;
        super("opt_live_boradcast_context_slardar_log", "屏蔽LiveBroadcastContext上报无用日志", r1, r1);
    }
}
