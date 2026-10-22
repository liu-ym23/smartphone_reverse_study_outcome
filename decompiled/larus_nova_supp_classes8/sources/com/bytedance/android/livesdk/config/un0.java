package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class un0 extends SettingKey<Boolean> {
    public static final un0 a = null;

    static {
        a = new un0();
    }

    public un0() {
        Boolean r1 = Boolean.TRUE;
        super("live_room_battle_video_remote_mute_fallback", "视频厅战兜底muteRemoteVideo false", r1, r1);
    }
}
