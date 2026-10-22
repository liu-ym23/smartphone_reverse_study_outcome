package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LiveRoomMemoryOptConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class po0 extends SSettingKey<LiveRoomMemoryOptConfig> {
    public static final po0 a = null;

    static {
        a = new po0();
    }

    public po0() {
        super("live_room_memory_opt", "直播内存治理优化", new LiveRoomMemoryOptConfig(), new LiveRoomMemoryOptConfig());
    }
}
