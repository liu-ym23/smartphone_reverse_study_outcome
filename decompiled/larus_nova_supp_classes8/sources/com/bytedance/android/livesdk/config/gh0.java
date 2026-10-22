package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gh0 extends SSettingKey<Boolean> {
    public static final gh0 a = null;

    static {
        a = new gh0();
    }

    public gh0() {
        Boolean r1 = Boolean.TRUE;
        super("live_pk_kick_out_reset_after_end_success", "浮窗布局下Pk踢人在onEndSuccess中提前reset", r1, r1);
    }
}
