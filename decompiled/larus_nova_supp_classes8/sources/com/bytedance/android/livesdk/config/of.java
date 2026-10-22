package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class of extends SSettingKey<Boolean> {
    public static final of a = null;

    static {
        a = new of();
    }

    public of() {
        Boolean r1 = Boolean.FALSE;
        super("paid_live_auto_open_payment_page", "付费直播试看结束后自动拉提单", r1, r1);
    }
}
