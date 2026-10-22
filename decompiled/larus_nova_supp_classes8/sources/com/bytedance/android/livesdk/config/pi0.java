package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.PlayerVrConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pi0 extends SSettingKey<PlayerVrConfig> {
    public static final pi0 a = null;

    static {
        a = new pi0();
    }

    public pi0() {
        super("live_player_vr_config", "播放器VR配置", new PlayerVrConfig(false, false, false, false, null, false, null, 0.0f, 255, null), new PlayerVrConfig(false, false, false, false, null, false, null, 0.0f, 255, null));
    }
}
