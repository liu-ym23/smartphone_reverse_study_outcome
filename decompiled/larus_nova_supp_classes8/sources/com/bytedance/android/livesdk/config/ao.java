package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ao extends SSettingKey<Boolean> {
    public static final ao a = null;

    static {
        a = new ao();
    }

    public ao() {
        Boolean r1 = Boolean.TRUE;
        super("live_disable_old_container_chatroom_admin", "聊天室管理员是否下线直播老容器", r1, r1);
    }
}
