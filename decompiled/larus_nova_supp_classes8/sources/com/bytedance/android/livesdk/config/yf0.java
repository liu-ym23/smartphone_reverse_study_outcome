package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.performance.LivePerformancePythiaConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class yf0 extends SSettingKey<LivePerformancePythiaConfig> {
    public static final yf0 a = null;

    static {
        a = new yf0();
    }

    public yf0() {
        super("live_performance_pythia_config", "pythia配置", new LivePerformancePythiaConfig(), new LivePerformancePythiaConfig());
    }
}
