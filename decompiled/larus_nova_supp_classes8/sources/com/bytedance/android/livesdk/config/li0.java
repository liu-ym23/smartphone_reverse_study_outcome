package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LivePlayerSmoothEnterRoomConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class li0 extends SSettingKey<LivePlayerSmoothEnterRoomConfig> {
    public static final li0 a = null;

    static {
        li0 r0 = new li0();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public li0() {
        super("live_player_smooth_enter_room", "多人场景预览流播放器平滑进房优化", new LivePlayerSmoothEnterRoomConfig(), new LivePlayerSmoothEnterRoomConfig());
    }
}
