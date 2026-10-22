package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b70 extends SSettingKey<Long> {
    public static final b70 a = null;

    static {
        a = new b70();
    }

    public b70() {
        super("live_load_stall_monitor_duration", "起播卡顿采集间隔，单位ms", -1L, -1L);
    }
}
