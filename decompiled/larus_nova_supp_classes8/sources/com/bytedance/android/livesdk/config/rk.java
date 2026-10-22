package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class rk extends SSettingKey<Boolean> {
    public static final rk a = null;

    static {
        a = new rk();
    }

    public rk() {
        Boolean r1 = Boolean.FALSE;
        super("live_clean_mode_hide_gradient_layer", "看播端竖屏清屏模式下是否隐藏上下蒙层", r1, r1);
    }
}
