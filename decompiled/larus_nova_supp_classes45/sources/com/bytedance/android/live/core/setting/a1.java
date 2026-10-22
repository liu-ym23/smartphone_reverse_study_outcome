package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a1 extends SSettingKey<Boolean> {
    public static final a1 a = null;

    static {
        a = new a1();
    }

    public a1() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_new_condition", "短触临态策略新旧频控开关", r1, r1);
    }
}
