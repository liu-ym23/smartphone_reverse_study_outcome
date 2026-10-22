package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class yn0 extends SSettingKey<Integer> {
    public static final yn0 a = null;

    static {
        a = new yn0();
    }

    public yn0() {
        super("live_room_channel_message_ahead_buffer_size", "房间频道消息超前缓存量", 200, 200);
    }
}
