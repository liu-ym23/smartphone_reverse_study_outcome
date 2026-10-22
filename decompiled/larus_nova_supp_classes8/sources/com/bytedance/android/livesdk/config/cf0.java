package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class cf0 extends SSettingKey<Boolean> {
    public static final cf0 a = null;

    static {
        a = new cf0();
    }

    public cf0() {
        Boolean r1 = Boolean.TRUE;
        super("live_paid_live_async_authentication_enable", "付费直播打开流异步鉴权", r1, r1);
    }
}
