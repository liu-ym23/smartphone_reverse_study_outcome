package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u0 extends SSettingKey<Boolean> {
    public static final u0 a = null;

    static {
        a = new u0();
    }

    public u0() {
        Boolean r1 = Boolean.FALSE;
        super("live_dynamic_unregister_wrds_enable", "动态化解注册wrds", r1, r1);
    }
}
