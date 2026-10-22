package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i01 extends SSettingKey<Boolean> {
    public static final i01 a = null;

    static {
        a = new i01();
    }

    public i01() {
        Boolean r1 = Boolean.FALSE;
        super("location_in_hk_mo_tw", "是否为港澳台用户，通过用户肉身位置判断", r1, r1);
    }
}
