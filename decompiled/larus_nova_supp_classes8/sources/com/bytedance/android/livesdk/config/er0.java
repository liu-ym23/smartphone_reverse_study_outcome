package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class er0 extends SettingKey<Boolean> {
    public static final er0 a = null;

    static {
        a = new er0();
    }

    public er0() {
        Boolean r1 = Boolean.TRUE;
        super("live_secret_shield_enabled", "RechargeScreenShield是否开启防截屏功能", r1, r1);
    }
}
