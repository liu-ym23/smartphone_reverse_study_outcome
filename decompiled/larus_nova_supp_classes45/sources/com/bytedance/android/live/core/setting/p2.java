package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMockStrategyDescriptorLoadConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p2 extends SSettingKey<LiveMockStrategyDescriptorLoadConfig> {
    public static final p2 a = null;

    static {
        a = new p2();
    }

    public p2() {
        super("live_mock_component_strategy_detail", "组件加载策略配置本地mock策略数据", new LiveMockStrategyDescriptorLoadConfig(), new LiveMockStrategyDescriptorLoadConfig(), true);
    }
}
