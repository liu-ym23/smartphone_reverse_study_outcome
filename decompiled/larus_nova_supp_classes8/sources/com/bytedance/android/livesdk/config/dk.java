package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dk extends SSettingKey<Long> {
    public static final dk a = null;

    static {
        a = new dk();
    }

    public dk() {
        super("live_chat_channel_config_message_update_interval", "好友频道配置-消息刷新间隔", 500L, 500L);
    }
}
