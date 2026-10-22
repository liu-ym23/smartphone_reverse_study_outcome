package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wz0 extends SSettingKey<Boolean> {
    public static final wz0 a = null;

    static {
        a = new wz0();
    }

    public wz0() {
        Boolean r1 = Boolean.TRUE;
        super("live_xplay_single_cast_stream_adapt", "Xplay个播推流使用新屏幕适配方案", r1, r1);
    }
}
