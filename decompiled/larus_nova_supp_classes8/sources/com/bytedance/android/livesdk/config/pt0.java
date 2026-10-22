package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.StreamColorMonitorConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pt0 extends SSettingKey<StreamColorMonitorConfig> {
    public static final pt0 a = null;

    static {
        a = new pt0();
    }

    public pt0() {
        super("live_stream_color_monitor_config", "流色彩采集配置", new StreamColorMonitorConfig(), new StreamColorMonitorConfig());
    }
}
