package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h4 extends SSettingKey<Boolean> {
    public static final h4 a = null;

    static {
        a = new h4();
    }

    public h4() {
        Boolean r1 = Boolean.FALSE;
        super("live_resource_balance_switch_battery", "资源平衡框架低电量开关", r1, r1);
    }
}
