package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class me0 extends SSettingKey<Boolean> {
    public static final me0 a = null;

    static {
        a = new me0();
    }

    public me0() {
        Boolean r1 = Boolean.FALSE;
        super("live_open_platform_sonic_pause_js_on_hide", "支持云游戏能力的sonic退后台后是否暂停js", r1, r1);
    }
}
