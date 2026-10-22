package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class zp0 extends SSettingKey<Double> {
    public static final zp0 a = null;

    static {
        a = new zp0();
    }

    public zp0() {
        Double r0 = Double.valueOf(-1.0d);
        super("live_scrollable_angle", "直播内流滑动角度调整", r0, r0);
    }
}
