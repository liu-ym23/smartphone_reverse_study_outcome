package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k4 extends SSettingKey<Boolean> {
    public static final k4 a = null;

    static {
        a = new k4();
    }

    public k4() {
        Boolean r1 = Boolean.FALSE;
        super("live_resource_balance_switch_v2", "资源平衡框架电量和增强开关", r1, r1);
    }
}
