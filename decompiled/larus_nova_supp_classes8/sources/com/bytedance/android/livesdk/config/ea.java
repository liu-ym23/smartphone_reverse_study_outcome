package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LiveDynamicSRConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ea extends SSettingKey<LiveDynamicSRConfig> {
    public static final ea a = null;

    static {
        a = new ea();
    }

    public ea() {
        super("live_ai_dynamic_sr", "直播动态超分配置", new LiveDynamicSRConfig(), new LiveDynamicSRConfig());
    }
}
