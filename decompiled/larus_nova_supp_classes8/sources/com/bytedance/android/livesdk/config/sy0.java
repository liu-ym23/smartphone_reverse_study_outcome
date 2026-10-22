package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sy0 extends SSettingKey<Boolean> {
    public static final sy0 a = null;

    static {
        a = new sy0();
    }

    public sy0() {
        Boolean r1 = Boolean.TRUE;
        super("live_welfare_log_add_ad_info", "直播公益埋点上报新增广告参数", r1, r1);
    }
}
