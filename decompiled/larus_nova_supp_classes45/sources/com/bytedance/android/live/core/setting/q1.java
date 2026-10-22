package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.performance.fwatchdog.LiveFWatchDogV2Config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q1 extends SSettingKey<LiveFWatchDogV2Config> {
    public static final q1 a = null;

    static {
        a = new q1();
    }

    public q1() {
        super("live_fwatch_dog_v2_config", "fwatchdogV2配置", new LiveFWatchDogV2Config(), new LiveFWatchDogV2Config());
    }
}
