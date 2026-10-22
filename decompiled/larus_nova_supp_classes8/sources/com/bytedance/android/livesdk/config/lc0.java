package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.PlayModeEnterInfoConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lc0 extends SettingKey<PlayModeEnterInfoConfig> {
    public static final lc0 a = null;

    static {
        lc0 r0 = new lc0();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public lc0() {
        PlayModeEnterInfoConfig.Companion r0 = PlayModeEnterInfoConfig.Companion;
        super("live_multi_scene_play_mode_from_enter_info", "多人场景玩法信息提前获取", r0.defaultConfig(), r0.defaultConfig());
    }
}
