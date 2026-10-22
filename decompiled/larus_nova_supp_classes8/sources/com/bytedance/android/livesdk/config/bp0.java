package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bp0 extends SSettingKey<c0> {
    public static final bp0 a = null;

    static {
        a = new bp0();
    }

    public bp0() {
        super("live_room_perf_duration", "稳定开播后性能采样配置，单位min", new c0(0), new c0(0));
    }
}
