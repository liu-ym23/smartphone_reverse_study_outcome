package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b8 extends SSettingKey<Boolean> {
    public static final b8 a = null;

    static {
        a = new b8();
    }

    public b8() {
        Boolean r1 = Boolean.FALSE;
        super("is_oversea_new_user", "是否为海外新用户，通过用户户口位置判断", r1, r1);
    }
}
