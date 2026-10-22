package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ef0 extends SSettingKey<Boolean> {
    public static final ef0 a = null;

    static {
        a = new ef0();
    }

    public ef0() {
        Boolean r1 = Boolean.TRUE;
        super("live_paid_live_enable_linkmic", "付费直播间支持用户连线能力", r1, r1);
    }
}
