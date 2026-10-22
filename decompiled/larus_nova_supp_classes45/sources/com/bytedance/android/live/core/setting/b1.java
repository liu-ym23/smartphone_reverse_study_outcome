package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b1 extends SSettingKey<Boolean> {
    public static final b1 a = null;

    static {
        a = new b1();
    }

    public b1() {
        Boolean r1 = Boolean.TRUE;
        super("live_shorttouch_strategy_condition_enable", "短触临态策略展示频控开关", r1, r1);
    }
}
