package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class at0 extends SSettingKey<Boolean> {
    public static final at0 a = null;

    static {
        a = new at0();
    }

    public at0() {
        Boolean r1 = Boolean.TRUE;
        super("live_sonic_game_leak_opt", "直播间Sonic游戏内存泄露优化", r1, r1);
    }
}
