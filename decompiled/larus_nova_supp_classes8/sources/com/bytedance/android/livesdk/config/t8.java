package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t8 extends SSettingKey<Boolean> {
    public static final t8 a = null;

    static {
        a = new t8();
    }

    public t8() {
        Boolean r1 = Boolean.TRUE;
        super("jsb_enable_permission_check", "启用 JSB 鉴权", r1, r1);
    }
}
