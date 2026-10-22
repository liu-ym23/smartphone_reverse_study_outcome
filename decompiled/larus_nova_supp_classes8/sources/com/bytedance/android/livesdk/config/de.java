package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.ai.config.LiveDetectionConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class de extends SSettingKey<LiveDetectionConfig> {
    public static final de a = null;

    static {
        a = new de();
    }

    public de() {
        super("live_detection_setting", LiveDetectionConfig.class, "直播客户端异常实时检测配置", new LiveDetectionConfig(), new LiveDetectionConfig());
    }
}
