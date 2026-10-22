package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wl extends SSettingKey<Boolean> {
    public static final wl a = null;

    static {
        a = new wl();
    }

    public wl() {
        Boolean r4 = Boolean.TRUE;
        super("live_common_minor_intercept", "未成年拦截开关", r4, r4, true);
    }
}
