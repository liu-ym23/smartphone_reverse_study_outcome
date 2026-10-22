package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class zn extends SSettingKey<Boolean> {
    public static final zn a = null;

    static {
        a = new zn();
    }

    public zn() {
        Boolean r1 = Boolean.TRUE;
        super("live_disable_old_container_chatroom", "聊天室是否下线直播老容器", r1, r1);
    }
}
