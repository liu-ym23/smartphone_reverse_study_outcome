package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j50 extends SSettingKey<Boolean> {
    public static final j50 a = null;

    static {
        a = new j50();
    }

    public j50() {
        Boolean r1 = Boolean.FALSE;
        super("live_landscape_hide_right_card_when_locked_enable", "横屏直播间锁屏时隐藏右侧卡片", r1, r1);
    }
}
