package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LiveRoomAPMConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class on0 extends SSettingKey<LiveRoomAPMConfig> {
    public static final on0 a = null;

    static {
        a = new on0();
    }

    public on0() {
        super("live_room_apm_setting_config", "直播间诊断APM", new LiveRoomAPMConfig(), new LiveRoomAPMConfig());
    }
}
