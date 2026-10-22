package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qh0 extends SSettingKey<Boolean> {
    public static final qh0 a = null;

    static {
        a = new qh0();
    }

    public qh0() {
        Boolean r1 = Boolean.TRUE;
        super("live_support_start_pk_with_audience", "是否支持主播带嘉宾发起 PK", r1, r1);
    }
}
