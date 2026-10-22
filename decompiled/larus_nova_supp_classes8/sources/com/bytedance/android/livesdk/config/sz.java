package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sz extends SSettingKey<Boolean> {
    public static final sz a = null;

    static {
        a = new sz();
    }

    public sz() {
        Boolean r1 = Boolean.TRUE;
        super("live_hamlet_avatar_enable_mix_game_audio", "hamlet avatar是否支持混音游戏声音", r1, r1);
    }
}
