package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ye extends SSettingKey<Boolean> {
    public static final ye a = null;

    static {
        a = new ye();
    }

    public ye() {
        Boolean r1 = Boolean.FALSE;
        super("ttlive_game_andience_receive_anchor_end_message_to_stop_game", "观众是否接收主播关播消息并结束游戏", r1, r1);
    }
}
