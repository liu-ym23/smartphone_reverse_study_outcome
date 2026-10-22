package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bk extends SSettingKey<Integer> {
    public static final bk a = null;

    static {
        a = new bk();
    }

    public bk() {
        super("live_chat_channel_config_message_max_size", "好友频道配置-消息展示最大值", 200, 200);
    }
}
