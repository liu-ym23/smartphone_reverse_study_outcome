package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q90 extends SSettingKey<Boolean> {
    public static final q90 a = null;

    static {
        a = new q90();
    }

    public q90() {
        Boolean r1 = Boolean.FALSE;
        super("live_open_native_app_continue_watch_enable", "小程序看播时长埋点逻辑更改", r1, r1);
    }
}
