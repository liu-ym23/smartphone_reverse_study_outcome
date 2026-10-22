package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hh0 extends SSettingKey<Boolean> {
    public static final hh0 a = null;

    static {
        a = new hh0();
    }

    public hh0() {
        Boolean r1 = Boolean.TRUE;
        super("live_pk_monitor_rtc_resolution_enable", "pk及多人主播连线监控推流分辨率开关", r1, r1);
    }
}
