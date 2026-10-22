package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ci extends SSettingKey<Boolean> {
    public static final ci a = null;

    static {
        a = new ci();
    }

    public ci() {
        Boolean r1 = Boolean.TRUE;
        super("live_broadcast_stable_mode_enable", "开播稳定模式", r1, r1);
    }
}
