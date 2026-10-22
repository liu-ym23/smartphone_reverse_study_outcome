package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lj1 extends SSettingKey<Long> {
    public static final lj1 a = null;

    static {
        a = new lj1();
    }

    public lj1() {
        super("vs_digg_tap_max_interval", "VS点赞触发间隔 (ms)", 300L, 300L);
    }
}
