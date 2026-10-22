package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class yq extends SSettingKey<Boolean> {
    public static final yq a = null;

    static {
        a = new yq();
    }

    public yq() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_audience_invite_friends", "实验：是否开启聊天室好友邀请", r1, r1);
    }
}
