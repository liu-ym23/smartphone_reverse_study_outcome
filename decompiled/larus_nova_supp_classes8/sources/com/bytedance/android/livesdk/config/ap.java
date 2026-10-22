package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.DrawerCardLynxConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ap extends SSettingKey<DrawerCardLynxConfig> {
    public static final ap a = null;

    static {
        a = new ap();
    }

    public ap() {
        super("live_drawer_card_lynx_config", DrawerCardLynxConfig.class, "更多直播中心化card参数配置", new DrawerCardLynxConfig(), null);
    }
}
