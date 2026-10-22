package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class zg extends SSettingKey<Boolean> {
    public static final zg a = null;

    static {
        a = new zg();
    }

    public zg() {
        Boolean r1 = Boolean.TRUE;
        super("live_broadcast_effect_params_performance_report", "开播性能埋点添加effect参数", r1, r1);
    }
}
