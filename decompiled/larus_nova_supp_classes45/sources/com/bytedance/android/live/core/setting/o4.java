package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o4 extends SSettingKey<Boolean> {
    public static final o4 a = null;

    static {
        a = new o4();
    }

    public o4() {
        Boolean r1 = Boolean.FALSE;
        super("live_resource_balance_switch_v6", "资源平衡框架屏蔽流畅看播", r1, r1);
    }
}
