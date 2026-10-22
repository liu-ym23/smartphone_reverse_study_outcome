package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h2 extends SSettingKey<Boolean> {
    public static final h2 a = null;

    static {
        a = new h2();
    }

    public h2() {
        super("dns_opt_free_flow_enable", Boolean.FALSE, "免流用户是否开启节点优选");
    }
}
