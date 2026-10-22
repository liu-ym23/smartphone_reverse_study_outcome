package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ih extends SSettingKey<Integer> {
    public static final ih a = null;

    static {
        a = new ih();
    }

    public ih() {
        super("live_broadcast_monitor_hprof_up", "主播监控存储hprof文件采样率", 10, 10);
    }
}
