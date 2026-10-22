package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.ReportConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bf1 extends SSettingKey<ReportConfig> {
    public static final bf1 a = null;

    static {
        a = new bf1();
    }

    public bf1() {
        super("report_config", "客户端举报配置", new ReportConfig(), new ReportConfig());
    }
}
