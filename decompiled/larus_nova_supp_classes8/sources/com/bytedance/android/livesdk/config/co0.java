package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveRoomCreateConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class co0 extends SettingKey<LiveRoomCreateConfig> {
    public static final co0 a = null;

    static {
        a = new co0();
    }

    public co0() {
        super("live_room_create_opt", "直播建房流程优化", new LiveRoomCreateConfig(), new LiveRoomCreateConfig(), true);
    }
}
