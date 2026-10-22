package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LivePlayerRevSmoothEnterRoomConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fi0 extends SSettingKey<LivePlayerRevSmoothEnterRoomConfig> {
    public static final fi0 a = null;

    static {
        a = new fi0();
    }

    public fi0() {
        super("live_player_rev_smooth_enter_room", "营收场景预览流播放器平滑进房优化", new LivePlayerRevSmoothEnterRoomConfig(), new LivePlayerRevSmoothEnterRoomConfig());
    }
}
