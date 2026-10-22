package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.depend.model.LiveStartRoomOptConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ht0 extends SSettingKey<LiveStartRoomOptConfig> {
    public static final ht0 a = null;

    static {
        a = new ht0();
    }

    public ht0() {
        super("live_start_room_opt_switch", "直播秒开开关", new LiveStartRoomOptConfig(), new LiveStartRoomOptConfig());
    }
}
