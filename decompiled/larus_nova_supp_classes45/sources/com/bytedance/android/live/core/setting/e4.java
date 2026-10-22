package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e4 extends SSettingKey<Boolean> {
    public static final e4 a = null;

    static {
        a = new e4();
    }

    public e4() {
        Boolean r1 = Boolean.TRUE;
        super("webcast_redirect_url_remove_auth_header", "redirect重定向规则接口去除 Authorization header", r1, r1);
    }
}
