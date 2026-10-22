package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t80 extends SSettingKey<Boolean> {
    public static final t80 a = null;

    static {
        a = new t80();
    }

    public t80() {
        Boolean r1 = Boolean.FALSE;
        super("live_message_start_before_room_enter", "直播消息建连在进房之前", r1, r1);
    }
}
