package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v90 extends SSettingKey<Boolean> {
    public static final v90 a = null;

    static {
        a = new v90();
    }

    public v90() {
        Boolean r1 = Boolean.TRUE;
        super("live_monitor_page_lifecycle", "直播中页面生命周期监控", r1, r1);
    }
}
