package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.EnterRoomFrameworkConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gu extends SSettingKey<EnterRoomFrameworkConfig> {
    public static final gu a = null;

    static {
        a = new gu();
    }

    public gu() {
        super("live_enter_room_container_config", "是否使用新的进房架构", new EnterRoomFrameworkConfig(), new EnterRoomFrameworkConfig(), true);
    }
}
