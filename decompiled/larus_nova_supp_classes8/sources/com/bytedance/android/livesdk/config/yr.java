package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class yr extends SSettingKey<Boolean> {
    public static final yr a = null;

    static {
        a = new yr();
    }

    public yr() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_instant_cpu_rate", "是否允许CPU瞬时采集", r1, r1);
    }
}
