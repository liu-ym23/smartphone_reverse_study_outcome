package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bz0 extends SSettingKey<Boolean> {
    public static final bz0 a = null;

    static {
        a = new bz0();
    }

    public bz0() {
        Boolean r1 = Boolean.FALSE;
        super("live_window_utils_log_switch", "直播windowUtils埋点上报", r1, r1);
    }
}
