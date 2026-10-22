package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s8 extends SSettingKey<Boolean> {
    public static final s8 a = null;

    static {
        a = new s8();
    }

    public s8() {
        Boolean r1 = Boolean.FALSE;
        super("jsb_enable_host_method_import", "启用 JSB 宿主方法注入", r1, r1);
    }
}
