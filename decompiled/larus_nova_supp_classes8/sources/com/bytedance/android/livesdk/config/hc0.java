package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hc0 extends SSettingKey<MultiRoomData> {
    public static final hc0 a = null;

    static {
        a = new hc0();
    }

    public hc0() {
        super("live_multi_room_preload_config", "预加载直播间", new MultiRoomData(), new MultiRoomData(), true);
    }
}
