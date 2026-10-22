package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class er extends SSettingKey<Boolean> {
    public static final er a = null;

    static {
        a = new er();
    }

    public er() {
        Boolean r1 = Boolean.TRUE;
        super("live_cast_proxy_enable", "是否使用bytecast投屏代理", r1, r1);
    }
}
