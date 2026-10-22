package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ve0 extends SSettingKey<Boolean> {
    public static final ve0 a = null;

    static {
        a = new ve0();
    }

    public ve0() {
        Boolean r1 = Boolean.TRUE;
        super("live_outside_small_window_enable", "站外悬浮小窗开关", r1, r1);
    }
}
