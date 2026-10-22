package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ar0 extends SSettingKey<Boolean> {
    public static final ar0 a = null;

    static {
        a = new ar0();
    }

    public ar0() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_feed_drawer_search", "允许搜索", r1, r1);
    }
}
