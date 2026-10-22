package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gk extends SSettingKey<Boolean> {
    public static final gk a = null;

    static {
        a = new gk();
    }

    public gk() {
        Boolean r1 = Boolean.TRUE;
        super("live_chat_channel_invite_bugfix_enable", "聊天频道自定义频道邀请bugfix", r1, r1);
    }
}
