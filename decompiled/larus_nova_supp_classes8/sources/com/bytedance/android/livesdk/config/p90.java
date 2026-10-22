package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p90 extends SSettingKey<Boolean> {
    public static final p90 a = null;

    static {
        a = new p90();
    }

    public p90() {
        Boolean r1 = Boolean.FALSE;
        super("live_mini_app_user_message", "小程序和电商互斥依赖消息", r1, r1);
    }
}
