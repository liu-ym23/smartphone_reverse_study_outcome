package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.TimeConsumingFuncOpt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pu0 extends SettingKey<TimeConsumingFuncOpt> {
    public static final pu0 a = null;

    static {
        a = new pu0();
    }

    public pu0() {
        super("live_time_consuming_func_opt", "慢函数治理", new TimeConsumingFuncOpt(), new TimeConsumingFuncOpt());
    }
}
