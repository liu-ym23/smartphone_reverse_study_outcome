package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c8 extends SSettingKey<Boolean> {
    public static final c8 a = null;

    static {
        a = new c8();
    }

    public c8() {
        Boolean r1 = Boolean.FALSE;
        super("is_oversea_old_user", "是否为海外老用户，通过用户户口位置判断", r1, r1);
    }
}
