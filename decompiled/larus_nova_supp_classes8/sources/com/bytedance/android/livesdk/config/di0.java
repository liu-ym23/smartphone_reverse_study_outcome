package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.PlayerOptimizeConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class di0 extends SSettingKey<PlayerOptimizeConfig> {
    public static final di0 a = null;

    static {
        di0 r0 = new di0();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public di0() {
        super("live_player_optimize_config", "播放器性能优化配置", new PlayerOptimizeConfig(), new PlayerOptimizeConfig());
    }
}
