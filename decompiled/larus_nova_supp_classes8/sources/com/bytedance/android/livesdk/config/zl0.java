package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class zl0 extends SSettingKey<Boolean> {
    public static final zl0 a = null;

    static {
        a = new zl0();
    }

    public zl0() {
        Boolean r1 = Boolean.TRUE;
        super("live_real_time_chorus_concert_first_frame_notify", "实时合唱演唱会首帧渲染回调", r1, r1);
    }
}
