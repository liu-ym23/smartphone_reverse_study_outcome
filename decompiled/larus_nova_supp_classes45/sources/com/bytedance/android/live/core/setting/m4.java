package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m4 extends SSettingKey<Boolean> {
    public static final m4 a = null;

    static {
        a = new m4();
    }

    public m4() {
        Boolean r1 = Boolean.TRUE;
        super("live_resource_balance_switch_v4", "资源平衡框架支持批处理", r1, r1);
    }
}
