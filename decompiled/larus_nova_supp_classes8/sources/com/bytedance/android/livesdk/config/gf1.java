package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gf1 extends SSettingKey<Boolean> {
    public static final gf1 a = null;

    static {
        a = new gf1();
    }

    public gf1() {
        Boolean r1 = Boolean.TRUE;
        super("rewrite_schema_enable", "重写schema开关", r1, r1);
    }
}
