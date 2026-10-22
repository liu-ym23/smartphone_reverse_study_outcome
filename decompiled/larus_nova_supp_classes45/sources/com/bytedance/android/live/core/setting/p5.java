package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p5 extends SSettingKey<Boolean> {
    public static final p5 a = null;

    static {
        a = new p5();
    }

    public p5() {
        Boolean r4 = Boolean.FALSE;
        super("live_use_component_strategy_in_anchor", "直播组件是否接入动态策略(主播)", r4, r4, false);
    }
}
