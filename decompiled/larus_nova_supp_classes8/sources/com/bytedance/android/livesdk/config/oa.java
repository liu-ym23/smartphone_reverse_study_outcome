package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.log.ALoggerConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class oa extends SSettingKey<ALoggerConfig> {
    public static final oa a = null;

    static {
        a = new oa();
    }

    public oa() {
        super("live_alogger_config", "直播日志打印配置", new ALoggerConfig(), new ALoggerConfig());
    }
}
