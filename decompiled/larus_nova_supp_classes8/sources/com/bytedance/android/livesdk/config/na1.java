package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.AVMonitorLogConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class na1 extends SSettingKey<AVMonitorLogConfig> {
    public static final na1 a = null;

    static {
        a = new na1();
    }

    public na1() {
        super("multi_link_av_monitor_log_config", "多人场景音频链路埋点配置", new AVMonitorLogConfig(), new AVMonitorLogConfig());
    }
}
