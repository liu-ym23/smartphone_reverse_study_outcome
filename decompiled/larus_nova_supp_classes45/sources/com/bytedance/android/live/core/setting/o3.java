package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o3 extends SSettingKey<Boolean> {
    public static final o3 a = null;

    static {
        a = new o3();
    }

    public o3() {
        Boolean r1 = Boolean.TRUE;
        super("live_opus_ktv_opt", "竖屏ktv性能优化", r1, r1);
    }
}
