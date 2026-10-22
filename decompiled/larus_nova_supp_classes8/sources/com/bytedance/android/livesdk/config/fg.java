package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.WindowFpsConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fg extends SSettingKey<WindowFpsConfig> {
    public static final fg a = null;

    static {
        a = new fg();
    }

    public fg() {
        super("live_base_window_fps_opt", "直播base window帧率优化", new WindowFpsConfig(), new WindowFpsConfig());
    }
}
