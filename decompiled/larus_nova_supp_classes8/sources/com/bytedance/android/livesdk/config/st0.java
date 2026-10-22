package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class st0 extends SSettingKey<Integer> {
    public static final st0 a = null;

    public st0() {
        super(LiveInitSettingKeys.LIVE_STREAM_STRATEGY_OPTIMIZER, 0, "是否开启流策略SDK", new String[]{"0:不开启", "1:开启"});
    }

    static {
        a = new st0();
    }
}
