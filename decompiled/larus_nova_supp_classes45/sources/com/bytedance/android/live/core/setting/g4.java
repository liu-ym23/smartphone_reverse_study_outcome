package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g4 extends SSettingKey<Boolean> {
    public static final g4 a = null;

    static {
        a = new g4();
    }

    public g4() {
        Boolean r1 = Boolean.FALSE;
        super("live_resource_balance_switch", "资源平衡框架整体开关", r1, r1);
    }
}
