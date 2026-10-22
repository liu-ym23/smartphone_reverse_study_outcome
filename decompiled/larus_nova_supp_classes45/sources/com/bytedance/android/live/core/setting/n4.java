package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n4 extends SSettingKey<Boolean> {
    public static final n4 a = null;

    static {
        a = new n4();
    }

    public n4() {
        Boolean r1 = Boolean.TRUE;
        super("live_resource_balance_switch_v5", "资源平衡框架屏蔽开播端", r1, r1);
    }
}
