package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dm0 extends SSettingKey<Boolean> {
    public static final dm0 a = null;

    static {
        a = new dm0();
    }

    public dm0() {
        Boolean r1 = Boolean.TRUE;
        super("live_real_time_chorus_push_stream_fix", "实时合唱推流时序问题调整", r1, r1);
    }
}
