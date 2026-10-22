package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class kp extends SSettingKey<Boolean> {
    public static final kp a = null;

    static {
        a = new kp();
    }

    public kp() {
        Boolean r1 = Boolean.FALSE;
        super("live_drawer_relax", "Relax抽屉开关", r1, r1);
    }
}
