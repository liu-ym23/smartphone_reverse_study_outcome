package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveAppLoggerConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class je extends SSettingKey<LiveAppLoggerConfig> {
    public static final je a = null;

    static {
        a = new je();
    }

    public je() {
        super("live_applogger_config", "直播埋点上报配置", new LiveAppLoggerConfig(), new LiveAppLoggerConfig());
    }
}
