package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.WeakRoomConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qu extends SSettingKey<WeakRoomConfig> {
    public static final qu a = null;

    static {
        a = new qu();
    }

    public qu() {
        super("live_enter_room_weak_fix", "一些内存泄露问题修复", new WeakRoomConfig(), new WeakRoomConfig(), true);
    }
}
