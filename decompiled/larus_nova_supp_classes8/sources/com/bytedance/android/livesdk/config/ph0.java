package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ph0 extends SSettingKey<Boolean> {
    public static final ph0 a = null;

    static {
        a = new ph0();
    }

    public ph0() {
        Boolean r1 = Boolean.TRUE;
        super("live_pk_support_link", "是否支持PK中观众上麦", r1, r1);
    }
}
