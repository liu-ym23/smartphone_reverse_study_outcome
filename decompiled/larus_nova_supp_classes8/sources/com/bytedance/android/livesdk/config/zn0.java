package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class zn0 extends SSettingKey<Boolean> {
    public static final zn0 a = null;

    static {
        a = new zn0();
    }

    public zn0() {
        Boolean r1 = Boolean.TRUE;
        super("live_room_channel_ws_message_push_enable", "房间频道消息是否支持长连接", r1, r1);
    }
}
