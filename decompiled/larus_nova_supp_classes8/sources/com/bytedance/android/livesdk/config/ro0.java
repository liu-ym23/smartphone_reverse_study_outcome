package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ro0 extends SSettingKey<Boolean> {
    public static final ro0 a = null;

    static {
        a = new ro0();
    }

    public ro0() {
        Boolean r1 = Boolean.FALSE;
        super("live_room_message_force_http", "直播消息强制使用http", r1, r1);
    }
}
