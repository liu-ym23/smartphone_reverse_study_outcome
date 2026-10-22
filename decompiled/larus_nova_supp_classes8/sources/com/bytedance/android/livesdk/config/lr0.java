package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LiveServerBlurBgConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lr0 extends SSettingKey<LiveServerBlurBgConfig> {
    public static final lr0 a = null;

    static {
        lr0 r0 = new lr0();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public lr0() {
        super("live_server_blur_bg_opt", "Server高斯模糊背景优化", new LiveServerBlurBgConfig(), new LiveServerBlurBgConfig());
    }
}
