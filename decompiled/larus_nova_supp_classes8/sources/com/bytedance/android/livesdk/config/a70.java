package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a70 extends SSettingKey<n51> {
    public static final a70 a = null;

    static {
        a = new a70();
    }

    public a70() {
        super("live_load_stall_monitor_delay_config", "起播卡顿延时采集，单位ms", new n51(), new n51());
    }
}
