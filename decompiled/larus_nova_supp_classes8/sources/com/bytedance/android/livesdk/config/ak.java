package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ak extends SSettingKey<Integer> {
    public static final ak a = null;

    static {
        a = new ak();
    }

    public ak() {
        super("live_chat_channel_config_message_cut_size", "好友频道配置-消息展示删减量", 70, 70);
    }
}
