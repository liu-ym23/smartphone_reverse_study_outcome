package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h7 extends SSettingKey<Boolean> {
    public static final h7 a = null;

    static {
        a = new h7();
    }

    public h7() {
        Boolean r1 = Boolean.FALSE;
        super("host_ws_message_debug_enable", "消息宿主长连调试开关", r1, r1);
    }
}
