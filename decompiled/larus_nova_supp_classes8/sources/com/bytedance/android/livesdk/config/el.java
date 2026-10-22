package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class el extends SSettingKey<Boolean> {
    public static final el a = null;

    static {
        a = new el();
    }

    public el() {
        Boolean r1 = Boolean.TRUE;
        super("live_clear_use_new_reset", "调整清屏reset的位置", r1, r1);
    }
}
