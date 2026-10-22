package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class tk extends SSettingKey<Boolean> {
    public static final tk a = null;

    static {
        a = new tk();
    }

    public tk() {
        Boolean r1 = Boolean.TRUE;
        super("live_clean_room_after_enter_enable", "是否支持进房完成后清屏", r1, r1);
    }
}
