package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fg0 extends SSettingKey<Boolean> {
    public static final fg0 a = null;

    static {
        a = new fg0();
    }

    public fg0() {
        Boolean r1 = Boolean.FALSE;
        super("live_perf_mode_risk_opt", "极速性能模式风险提示", r1, r1);
    }
}
