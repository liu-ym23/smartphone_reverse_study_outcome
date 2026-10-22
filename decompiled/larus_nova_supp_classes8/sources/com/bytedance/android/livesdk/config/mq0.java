package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mq0 extends SSettingKey<Boolean> {
    public static final mq0 a = null;

    static {
        a = new mq0();
    }

    public mq0() {
        Boolean r1 = Boolean.FALSE;
        super("live_screen_bgm_enable", "录屏直播支持BGM", r1, r1);
    }
}
