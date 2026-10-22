package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class if0 extends SSettingKey<Boolean> {
    public static final if0 a = null;

    static {
        a = new if0();
    }

    public if0() {
        Boolean r1 = Boolean.FALSE;
        super("live_paid_live_temp_watch_use_setting_froce", "付费直播试看时长强制用setting(调试用)", r1, r1);
    }
}
