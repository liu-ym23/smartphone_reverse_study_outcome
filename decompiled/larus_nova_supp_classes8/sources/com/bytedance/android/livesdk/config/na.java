package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class na extends SSettingKey<Boolean> {
    public static final na a = null;

    static {
        a = new na();
    }

    public na() {
        Boolean r1 = Boolean.FALSE;
        super("live_allow_old_lynx_monitor_report", "允许上报老监控", r1, r1);
    }
}
