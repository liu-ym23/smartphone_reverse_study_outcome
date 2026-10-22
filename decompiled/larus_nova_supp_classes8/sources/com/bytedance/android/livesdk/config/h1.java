package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h1 extends SSettingKey<Boolean> {
    public static final h1 a = null;

    static {
        a = new h1();
    }

    public h1() {
        Boolean r1 = Boolean.FALSE;
        super("live_clear_screen_click_player_opt", "清屏状态下点击播放器画面可以退出清屏", r1, r1);
    }
}
