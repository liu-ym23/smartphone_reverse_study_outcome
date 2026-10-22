package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mi1 extends SSettingKey<Boolean> {
    public static final mi1 a = null;

    static {
        a = new mi1();
    }

    public mi1() {
        Boolean r1 = Boolean.TRUE;
        super("user_info_secret_callback_assign_redress_enable", "UserInfoSecretCallback绑定时机纠正开关", r1, r1);
    }
}
