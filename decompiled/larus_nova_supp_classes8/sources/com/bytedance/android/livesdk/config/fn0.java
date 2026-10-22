package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fn0 extends SSettingKey<Boolean> {
    public static final fn0 a = null;

    static {
        a = new fn0();
    }

    public fn0() {
        Boolean r1 = Boolean.TRUE;
        super("live_revenue_interaction_sei_monitor", "交互层透传sei监控 开关", r1, r1);
    }
}
