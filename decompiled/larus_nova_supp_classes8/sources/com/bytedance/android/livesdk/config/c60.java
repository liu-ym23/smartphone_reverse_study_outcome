package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiLinkPerfBalanceConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c60 extends SSettingKey<MultiLinkPerfBalanceConfig> {
    public static final c60 a = null;

    static {
        a = new c60();
    }

    public c60() {
        super("live_linkmic_perf_balance_config", "多人性能降级开关", new MultiLinkPerfBalanceConfig(), new MultiLinkPerfBalanceConfig());
    }
}
