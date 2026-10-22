package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class rk0 extends SSettingKey<Boolean> {
    public static final rk0 a = null;

    static {
        a = new rk0();
    }

    public rk0() {
        super("live_privacy_room_logger_add_uid_monitor", "隐私直播间上报是否加上uid监控", Boolean.FALSE, Boolean.TRUE);
    }
}
