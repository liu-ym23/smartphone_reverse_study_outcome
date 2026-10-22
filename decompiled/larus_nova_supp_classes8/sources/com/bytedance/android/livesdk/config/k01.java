package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k01 extends SSettingKey<Boolean> {
    public static final k01 a = null;

    static {
        a = new k01();
    }

    public k01() {
        Boolean r1 = Boolean.TRUE;
        super("login_user_service_check_enable", "登录时判断宿主UserService是否为null", r1, r1);
    }
}
