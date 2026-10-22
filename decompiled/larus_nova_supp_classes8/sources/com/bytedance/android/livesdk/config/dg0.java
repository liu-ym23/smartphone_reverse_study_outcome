package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dg0 extends SSettingKey<Boolean> {
    public static final dg0 a = null;

    static {
        a = new dg0();
    }

    public dg0() {
        Boolean r1 = Boolean.TRUE;
        super("live_perf_jato_config", "直播JATO系统化能力开关", r1, r1);
    }
}
