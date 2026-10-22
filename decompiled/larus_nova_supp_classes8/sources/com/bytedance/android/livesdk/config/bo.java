package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bo extends SSettingKey<Boolean> {
    public static final bo a = null;

    static {
        a = new bo();
    }

    public bo() {
        Boolean r1 = Boolean.TRUE;
        super("live_disable_old_container_chatroom_toolbar", "聊天室工具栏是否下线直播老容器", r1, r1);
    }
}
