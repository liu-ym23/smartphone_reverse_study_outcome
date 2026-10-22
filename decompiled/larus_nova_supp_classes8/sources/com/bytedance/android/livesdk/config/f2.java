package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f2 extends SSettingKey<Long> {
    public static final f2 a = null;

    static {
        a = new f2();
    }

    public f2() {
        super("digg_tap_map_interval", "点赞触发间隔 (ms)", 700L, 500L);
    }
}
