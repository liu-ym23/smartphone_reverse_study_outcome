package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p1 extends SSettingKey<com.bytedance.android.live.core.monitor.trace.a.C0144a> {
    public static final p1 a = null;

    static {
        a = new p1();
    }

    public p1() {
        super("live_frequent_trace_report_config", "直播频繁trace监控", new com.bytedance.android.live.core.monitor.trace.a.C0144a(), new com.bytedance.android.live.core.monitor.trace.a.C0144a(), true);
    }
}
