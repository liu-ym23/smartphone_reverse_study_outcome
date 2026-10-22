package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g0 extends SSettingKey<Boolean> {
    public static final g0 a = null;

    static {
        a = new g0();
    }

    public g0() {
        Boolean r1 = Boolean.FALSE;
        super("live_component_strategy_default", "组件加载策略配置默认值", r1, r1);
    }
}
