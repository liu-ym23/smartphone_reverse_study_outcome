package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LiveSchemeSecurityConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ut0 extends SSettingKey<LiveSchemeSecurityConfig> {
    public static final ut0 a = null;

    static {
        a = new ut0();
    }

    public ut0() {
        super("live_subscheme_security_config", "二级Scheme安全校验配置", new LiveSchemeSecurityConfig(), new LiveSchemeSecurityConfig());
    }
}
