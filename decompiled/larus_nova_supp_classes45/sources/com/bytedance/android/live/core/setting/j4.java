package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j4 extends SSettingKey<Boolean> {
    public static final j4 a = null;

    static {
        a = new j4();
    }

    public j4() {
        Boolean r1 = Boolean.FALSE;
        super("live_resource_balance_switch_shell_temperature", "资源平衡框架壳温开关", r1, r1);
    }
}
