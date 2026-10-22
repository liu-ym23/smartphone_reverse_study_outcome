package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ub0 extends SSettingKey<Float> {
    public static final ub0 a = null;

    static {
        a = new ub0();
    }

    public ub0() {
        Float r0 = Float.valueOf(0.5f);
        super("live_multi_link_seat_space", "默认的麦位间距", r0, r0);
    }
}
