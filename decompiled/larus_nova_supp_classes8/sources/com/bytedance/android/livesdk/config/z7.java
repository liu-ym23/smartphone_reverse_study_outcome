package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.config.link.LinkRequestMonitorConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z7 extends SSettingKey<LinkRequestMonitorConfig> {
    public static final z7 a = null;

    static {
        a = new z7();
    }

    public z7() {
        super("interact_request_monitor_config", "连麦阶段请求监控配置", new LinkRequestMonitorConfig(), new LinkRequestMonitorConfig());
    }
}
