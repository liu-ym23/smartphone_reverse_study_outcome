package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.DrawerBannerLynxConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class zo extends SSettingKey<DrawerBannerLynxConfig> {
    public static final zo a = null;

    static {
        a = new zo();
    }

    public zo() {
        super("live_drawer_banner_lynx_config", DrawerBannerLynxConfig.class, "更多直播中心化banner参数配置", new DrawerBannerLynxConfig(), null);
    }
}
