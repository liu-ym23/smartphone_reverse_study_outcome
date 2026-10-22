package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q5 extends SSettingKey<Boolean> {
    public static final q5 a = null;

    static {
        a = new q5();
    }

    public q5() {
        Boolean r4 = Boolean.FALSE;
        super("live_use_component_strategy_in_landscape", "直播组件是否接入动态策略(横屏)", r4, r4, false);
    }
}
