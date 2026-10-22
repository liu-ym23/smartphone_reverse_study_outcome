package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m1 extends SSettingKey<Boolean> {
    public static final m1 a = null;

    static {
        a = new m1();
    }

    public m1() {
        Boolean r1 = Boolean.TRUE;
        super("live_clear_screen_fix_vs_portrait_click", "修复节目竖屏直播间单击进入清屏而不是唤起播控进度条的bug", r1, r1);
    }
}
