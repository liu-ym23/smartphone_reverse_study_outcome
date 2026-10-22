package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i4 extends SSettingKey<Boolean> {
    public static final i4 a = null;

    static {
        a = new i4();
    }

    public i4() {
        Boolean r1 = Boolean.FALSE;
        super("live_resource_balance_switch_outter_performance", "资源平衡框架外部性能感知开关", r1, r1);
    }
}
