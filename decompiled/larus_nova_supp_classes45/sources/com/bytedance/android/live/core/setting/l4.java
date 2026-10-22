package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l4 extends SSettingKey<Boolean> {
    public static final l4 a = null;

    static {
        a = new l4();
    }

    public l4() {
        Boolean r1 = Boolean.FALSE;
        super("live_resource_balance_switch_v3", "资源平衡框架原降级框架切换", r1, r1);
    }
}
