package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.config.setting.LiveUserStayTimeStrategyConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j5 extends SSettingKey<LiveUserStayTimeStrategyConfig> {
    public static final j5 a = null;

    static {
        a = new j5();
    }

    public j5() {
        super("live_stay_time_strategy_config", "用户看播预测配置", new LiveUserStayTimeStrategyConfig(), new LiveUserStayTimeStrategyConfig());
    }
}
