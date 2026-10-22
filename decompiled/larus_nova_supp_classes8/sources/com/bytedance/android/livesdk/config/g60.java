package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g60 extends SSettingKey<Boolean> {
    public static final g60 a = null;

    static {
        a = new g60();
    }

    public g60() {
        Boolean r1 = Boolean.TRUE;
        super("live_link_and_game_change_fix", "游戏直播刷到连屏后无法横屏fix", r1, r1);
    }
}
