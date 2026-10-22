package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lx0 extends SSettingKey<Boolean> {
    public static final lx0 a = null;

    static {
        a = new lx0();
    }

    public lx0() {
        Boolean r1 = Boolean.TRUE;
        super("live_vr_degrade_observer_enable", "是否开启VR降级策略因子监听", r1, r1);
    }
}
