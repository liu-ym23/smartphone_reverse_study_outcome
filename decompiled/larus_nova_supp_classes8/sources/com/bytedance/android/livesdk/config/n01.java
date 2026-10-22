package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n01 extends SSettingKey<Boolean> {
    public static final n01 a = null;

    static {
        a = new n01();
    }

    public n01() {
        boolean r0 = tb1.c.a;
        Boolean r1 = Boolean.TRUE;
        super("lynx_custom_report_add_biz", "custom report 是否加bizTag", r1, r1);
    }
}
