package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class oq extends SSettingKey<Boolean> {
    public static final oq a = null;

    static {
        a = new oq();
    }

    public oq() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_anchor_invite_friends", "实验：是否开启聊天室好友邀请", r1, r1);
    }
}
