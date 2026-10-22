package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class we extends SettingKey<Boolean> {
    public static final we a = null;

    static {
        a = new we();
    }

    public we() {
        Boolean r1 = Boolean.TRUE;
        super("live_audience_mini_app_commerce_both_existed", "小程序和购物车共存观众侧开关", r1, r1);
    }
}
