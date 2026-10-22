package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wz extends SSettingKey<Boolean> {
    public static final wz a = null;

    static {
        a = new wz();
    }

    public wz() {
        Boolean r1 = Boolean.TRUE;
        super("live_hamlet_avatar_v2_enable_rtc_ignore_sei", "hamlet avata二期是否支持丢弃云游SEI(rtc)", r1, r1);
    }
}
