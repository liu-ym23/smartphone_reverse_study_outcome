package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class iz0 extends SSettingKey<Boolean> {
    public static final iz0 a = null;

    static {
        a = new iz0();
    }

    public iz0() {
        Boolean r1 = Boolean.TRUE;
        super("live_ws_message_push_enable", "房间消息是否支持长连接", r1, r1);
    }
}
