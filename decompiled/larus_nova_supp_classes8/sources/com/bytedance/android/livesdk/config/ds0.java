package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ds0 extends SSettingKey<Boolean> {
    public static final ds0 a = null;

    static {
        a = new ds0();
    }

    public ds0() {
        Boolean r1 = Boolean.FALSE;
        super("live_shot_panel_enter_anim_enable", "截图面板入场动画开关", r1, r1);
    }
}
