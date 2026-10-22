package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ck extends SSettingKey<Float> {
    public static final ck a = null;

    static {
        a = new ck();
    }

    public ck() {
        Float r0 = Float.valueOf(550.0f);
        super("live_chat_channel_config_message_scroll_speed", "好友频道配置-消息列表滚动速度", r0, r0);
    }
}
