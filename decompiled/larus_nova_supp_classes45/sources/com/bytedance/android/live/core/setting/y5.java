package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y5 extends SSettingKey<Boolean> {
    public static final y5 a = null;

    static {
        a = new y5();
    }

    public y5() {
        Boolean r4 = Boolean.FALSE;
        super("live_vs_use_component_strategy_in_portrait", "直播组件是否接入动态策略(节目)", r4, r4, false);
    }
}
