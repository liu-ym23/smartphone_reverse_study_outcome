package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dj0 extends SSettingKey<Boolean> {
    public static final dj0 a = null;

    static {
        a = new dj0();
    }

    public dj0() {
        Boolean r1 = Boolean.TRUE;
        super("live_power_function_enable", "是否开启直播电池功耗采集", r1, r1);
    }
}
