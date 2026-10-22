package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.PlayerRoiSrConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gi0 extends SSettingKey<PlayerRoiSrConfig> {
    public static final gi0 a = null;

    static {
        a = new gi0();
    }

    public gi0() {
        super(LiveInitSettingKeys.LIVE_PLAYER_ROI_SR_CONFIG, "拉流播放器离ROI超分开关配置", new PlayerRoiSrConfig(), new PlayerRoiSrConfig());
    }
}
