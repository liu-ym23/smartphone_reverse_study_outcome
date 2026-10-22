package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dj extends SSettingKey<Boolean> {
    public static final dj a = null;

    static {
        a = new dj();
    }

    public dj() {
        Boolean r1 = Boolean.TRUE;
        super("live_byte_sync_message_enable", "是否支持ByteSync消息", r1, r1);
    }
}
