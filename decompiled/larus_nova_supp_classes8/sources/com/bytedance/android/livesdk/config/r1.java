package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r1 extends SSettingKey<Boolean> {
    public static final r1 a = null;

    static {
        a = new r1();
    }

    public r1() {
        Boolean r1 = Boolean.TRUE;
        super("live_fix_clear_screen_trans_anim_view_gone", "修复退出清屏位移动画结束后view是gone的bug", r1, r1);
    }
}
