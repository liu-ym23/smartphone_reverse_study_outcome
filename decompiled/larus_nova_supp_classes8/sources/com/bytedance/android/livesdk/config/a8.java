package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a8 extends SSettingKey<Integer> {
    public static final a8 a = null;

    static {
        a = new a8();
    }

    public a8() {
        super("interact_talk_invite_friends_interval", "聊天室强触达两次邀请同一用户最短间隔", 300, 300);
    }
}
