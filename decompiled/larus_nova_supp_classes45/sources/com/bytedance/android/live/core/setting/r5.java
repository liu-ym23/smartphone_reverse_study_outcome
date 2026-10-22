package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r5 extends SSettingKey<Boolean> {
    public static final r5 a = null;

    static {
        a = new r5();
    }

    public r5() {
        Boolean r4 = Boolean.FALSE;
        super("live_use_component_strategy_in_portrait", "直播组件是否接入动态策略(竖屏)", r4, r4, false);
    }
}
