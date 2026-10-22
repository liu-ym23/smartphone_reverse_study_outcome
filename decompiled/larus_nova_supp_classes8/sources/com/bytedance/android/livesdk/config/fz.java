package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fz extends SSettingKey<Long> {
    public static final fz a = null;

    static {
        a = new fz();
    }

    public fz() {
        super("live_gift_user_request_interval", "礼物消费频控User接口请求周期(s)", 86400L, 86400L);
    }
}
