package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.BigEventAvatarConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ig extends SSettingKey<BigEventAvatarConfig> {
    public static final ig a = null;

    static {
        a = new ig();
    }

    public ig() {
        super("live_big_event_avatar", "重保Avatar开关", new BigEventAvatarConfig(), new BigEventAvatarConfig());
    }
}
