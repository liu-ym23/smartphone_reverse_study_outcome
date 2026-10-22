package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qo0 extends SSettingKey<Boolean> {
    public static final qo0 a = null;

    static {
        a = new qo0();
    }

    public qo0() {
        Boolean r1 = Boolean.TRUE;
        super("live_room_message_filter_other_room", "直播间消息过滤其他房间消息", r1, r1);
    }
}
