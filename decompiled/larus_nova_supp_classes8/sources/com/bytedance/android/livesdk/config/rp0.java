package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class rp0 extends SSettingKey<Boolean> {
    public static final rp0 a = null;

    static {
        a = new rp0();
    }

    public rp0() {
        Boolean r1 = Boolean.FALSE;
        super("live_sandbox_miniapp_bootconfig_enable", "沙盒小程序屏蔽bootconfig请求开关", r1, r1);
    }
}
