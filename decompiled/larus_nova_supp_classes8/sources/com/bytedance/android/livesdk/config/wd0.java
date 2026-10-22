package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wd0 extends SSettingKey<Boolean> {
    public static final wd0 a = null;

    static {
        a = new wd0();
    }

    public wd0() {
        super("live_open_live_monitor_enable", "开播卡顿采集间隔，单位ms", Boolean.FALSE, Boolean.TRUE);
    }
}
