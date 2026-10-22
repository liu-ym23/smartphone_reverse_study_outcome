package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.PreConnectConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ud1 extends SSettingKey<PreConnectConfig> {
    public static final ud1 a = null;

    static {
        a = new ud1();
    }

    public ud1() {
        super("live_preconnect_config", "内流预建联配置", new PreConnectConfig(), new PreConnectConfig());
    }
}
