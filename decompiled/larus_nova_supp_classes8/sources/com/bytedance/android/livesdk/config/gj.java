package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gj extends SSettingKey<Boolean> {
    public static final gj a = null;

    static {
        a = new gj();
    }

    public gj() {
        Boolean r1 = Boolean.TRUE;
        super("live_card_show_intercept_on_screen_lock", "横屏锁屏状态下不展示讲解卡容器", r1, r1);
    }
}
