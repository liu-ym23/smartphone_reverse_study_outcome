package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lv0 extends SSettingKey<Boolean> {
    public static final lv0 a = null;

    static {
        a = new lv0();
    }

    public lv0() {
        Boolean r1 = Boolean.TRUE;
        super("live_turn_on_opt_enable", "开启RTC超时leave channel", r1, r1);
    }
}
