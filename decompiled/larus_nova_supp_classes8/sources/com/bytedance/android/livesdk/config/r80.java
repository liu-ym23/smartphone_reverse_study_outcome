package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r80 extends SSettingKey<Long> {
    public static final r80 a = null;

    static {
        a = new r80();
    }

    public r80() {
        super("live_message_server_limit_max_fetch_interval", "消息server限流最大轮询间隔", 8000L, 8000L);
    }
}
