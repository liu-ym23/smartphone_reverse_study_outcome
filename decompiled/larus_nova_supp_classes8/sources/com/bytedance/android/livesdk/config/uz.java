package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.HamletAvatarMockConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class uz extends SSettingKey<HamletAvatarMockConfig> {
    public static final uz a = null;

    static {
        a = new uz();
    }

    public uz() {
        super("live_hamlet_avatar_mock_config", "hamlet avatat mock参数配置", new HamletAvatarMockConfig(), new HamletAvatarMockConfig());
    }
}
