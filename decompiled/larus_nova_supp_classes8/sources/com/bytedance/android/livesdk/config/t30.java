package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t30 extends SSettingKey<Boolean> {
    public static final t30 a = null;

    static {
        a = new t30();
    }

    public t30() {
        Boolean r1 = Boolean.TRUE;
        super("live_jsb_enable_init_xbridge", "启用 JSB 宿主方法注入", r1, r1);
    }
}
