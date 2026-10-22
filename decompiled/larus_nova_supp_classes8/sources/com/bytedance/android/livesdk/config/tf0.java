package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class tf0 extends SSettingKey<Boolean> {
    public static final tf0 a = null;

    static {
        a = new tf0();
    }

    public tf0() {
        Boolean r1 = Boolean.FALSE;
        super("live_performance_enable_auto_defence", "开启自动防劣化开关", r1, r1);
    }
}
