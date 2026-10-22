package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r90 extends SSettingKey<Boolean> {
    public static final r90 a = null;

    static {
        a = new r90();
    }

    public r90() {
        Boolean r1 = Boolean.FALSE;
        super("live_mini_game_duration_optimize", "小游戏看播时长埋点逻辑更改", r1, r1);
    }
}
