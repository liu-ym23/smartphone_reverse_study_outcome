package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o50 extends SSettingKey<Boolean> {
    public static final o50 a = null;

    static {
        a = new o50();
    }

    public o50() {
        Boolean r1 = Boolean.FALSE;
        super("live_landscape_player_control_default_hide", "横屏时播控层是否默认隐藏，横屏进房时默认展开", r1, r1);
    }
}
