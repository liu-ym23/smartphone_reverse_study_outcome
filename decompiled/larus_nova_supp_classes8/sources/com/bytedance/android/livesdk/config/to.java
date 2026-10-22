package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.DnsOptimizeConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class to extends SSettingKey<DnsOptimizeConfig> {
    public static final to a = null;

    static {
        a = new to();
    }

    public to() {
        super("live_dns_optimize_config", "DNS优化配置", new DnsOptimizeConfig(), new DnsOptimizeConfig());
    }
}
