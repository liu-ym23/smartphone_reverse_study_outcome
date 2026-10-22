package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveTabliveGuideConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class eu0 extends SSettingKey<LiveTabliveGuideConfig> {
    public static final eu0 a = null;

    static {
        a = new eu0();
    }

    public eu0() {
        super("live_tablive_guide_common_config", "各直播tab引导通用配置", new LiveTabliveGuideConfig(), new LiveTabliveGuideConfig());
    }
}
