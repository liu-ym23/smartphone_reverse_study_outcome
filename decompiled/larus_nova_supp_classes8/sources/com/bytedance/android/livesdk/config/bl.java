package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bl extends SSettingKey<Boolean> {
    public static final bl a = null;

    static {
        a = new bl();
    }

    public bl() {
        Boolean r1 = Boolean.FALSE;
        super("live_clear_screen_optimize", "清屏体验优化", r1, r1);
    }
}
