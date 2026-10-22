package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vg0 extends SSettingKey<Boolean> {
    public static final vg0 a = null;

    static {
        a = new vg0();
    }

    public vg0() {
        Boolean r1 = Boolean.TRUE;
        super("live_ping_audience_optimize", "观众端ping接口优化", r1, r1);
    }
}
