package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class un extends SSettingKey<Boolean> {
    public static final un a = null;

    static {
        a = new un();
    }

    public un() {
        Boolean r1 = Boolean.FALSE;
        super("live_disable_end_page_auto_play", "火山直播结束页不再倒计时跳转下一个直播间", r1, r1);
    }
}
