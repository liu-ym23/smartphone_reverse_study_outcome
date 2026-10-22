package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class zm extends SSettingKey<Boolean> {
    public static final zm a = null;

    static {
        a = new zm();
    }

    public zm() {
        Boolean r1 = Boolean.TRUE;
        super(LiveInitSettingKeys.LIVE_DEGRADE_STRATEGY_SDK_ENABLE, "降级是否开启策略sdk方案", r1, r1);
    }
}
