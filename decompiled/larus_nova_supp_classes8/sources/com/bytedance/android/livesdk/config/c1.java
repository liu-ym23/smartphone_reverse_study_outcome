package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c1 extends SSettingKey<Boolean> {
    public static final c1 a = null;

    static {
        a = new c1();
    }

    public c1() {
        Boolean r1 = Boolean.TRUE;
        super("cloud_game_hide_plugin_behind_strt_activity", "启动云游戏后再隐藏小玩法面板", r1, r1);
    }
}
