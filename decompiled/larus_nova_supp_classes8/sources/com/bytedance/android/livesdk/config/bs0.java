package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bs0 extends SSettingKey<Boolean> {
    public static final bs0 a = null;

    static {
        a = new bs0();
    }

    public bs0() {
        Boolean r1 = Boolean.TRUE;
        super("live_short_touch_insert_control", "短触区管控能力开关", r1, r1);
    }
}
