package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.GroupLiveGameConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mz extends SSettingKey<GroupLiveGameConfig> {
    public static final mz a = null;

    static {
        mz r0 = new mz();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public mz() {
        super("live_group_live_game_config", GroupLiveGameConfig.class, "社交群/IM一起玩功能配置", new GroupLiveGameConfig(), new GroupLiveGameConfig());
    }
}
