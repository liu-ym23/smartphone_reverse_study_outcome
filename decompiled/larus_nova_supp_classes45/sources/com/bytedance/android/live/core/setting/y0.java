package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y0 extends SSettingKey<Boolean> {
    public static final y0 a = null;

    static {
        a = new y0();
    }

    public y0() {
        Boolean r4 = Boolean.FALSE;
        super("live_enable_host_reflect_opt", "是否开启宿主服务的反射优化", r4, r4, false);
    }
}
