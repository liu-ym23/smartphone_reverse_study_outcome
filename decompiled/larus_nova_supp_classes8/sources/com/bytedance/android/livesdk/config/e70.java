package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e70 extends SettingKey<Boolean> {
    public static final e70 a = null;

    static {
        a = new e70();
    }

    public e70() {
        Boolean r1 = Boolean.TRUE;
        super("live_logout_reset_user_attr", "退出登录是否重置user attr", r1, r1);
    }
}
