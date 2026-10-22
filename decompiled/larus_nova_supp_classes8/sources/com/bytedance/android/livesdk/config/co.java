package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class co extends SSettingKey<Boolean> {
    public static final co a = null;

    static {
        a = new co();
    }

    public co() {
        Boolean r1 = Boolean.TRUE;
        super("live_disable_old_container_chatroom_ui", "聊天室UI是否下线直播老容器", r1, r1);
    }
}
