package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q60 extends SSettingKey<Boolean> {
    public static final q60 a = null;

    static {
        a = new q60();
    }

    public q60() {
        Boolean r1 = Boolean.TRUE;
        super("live_link_message_decode_error_log", "LinkMessage解析失败Trace上报", r1, r1);
    }
}
