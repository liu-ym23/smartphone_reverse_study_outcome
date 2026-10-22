package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class tk0 extends SSettingKey<String> {
    public static final tk0 a = null;

    static {
        a = new tk0();
    }

    public tk0() {
        super("live_privacy_room_uid_log_prefix", "隐私直播间上报uid埋点前缀", "webcast_");
    }
}
