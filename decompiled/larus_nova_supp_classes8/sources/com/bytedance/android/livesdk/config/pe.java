package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pe extends SSettingKey<Boolean> {
    public static final pe a = null;

    static {
        a = new pe();
    }

    public pe() {
        Boolean r1 = Boolean.FALSE;
        super("live_async_report_wto_enable", "TEA埋点异步上报接入WTO", r1, r1);
    }
}
