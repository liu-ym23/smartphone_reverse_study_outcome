package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z0 extends SSettingKey<Boolean> {
    public static final z0 a = null;

    static {
        a = new z0();
    }

    public z0() {
        Boolean r4 = Boolean.FALSE;
        super("live_enable_lazy_constant", "datacontext contants 懒加载", r4, r4, true);
    }
}
