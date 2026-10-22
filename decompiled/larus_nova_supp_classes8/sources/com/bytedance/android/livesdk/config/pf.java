package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pf extends SSettingKey<Boolean> {
    public static final pf a = null;

    static {
        a = new pf();
    }

    public pf() {
        Boolean r1 = Boolean.TRUE;
        super("paid_live_auto_open_payment_page_check", "付费直播试看结束后自动拉提单是否检查当前提单页拉起状态", r1, r1);
    }
}
