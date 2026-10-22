package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.WormholeConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ez0 extends SSettingKey<WormholeConfig> {
    public static final ez0 a = null;

    static {
        ez0 r0 = new ez0();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public ez0() {
        super("live_wormhole_config", "直播wormhole配置", new WormholeConfig(), new WormholeConfig());
    }
}
