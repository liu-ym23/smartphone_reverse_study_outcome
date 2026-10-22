package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s90 extends SSettingKey<Boolean> {
    public static final s90 a = null;

    static {
        a = new s90();
    }

    public s90() {
        Boolean r1 = Boolean.TRUE;
        super("live_mini_game_fix", "小游戏看播时长调整修复", r1, r1);
    }
}
