package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class tv extends SSettingKey<Integer> {
    public static final tv a = null;

    public tv() {
        super("live_feed_filter_duplicate_num", "去重范围在连续多少个直播间", 4, 4);
    }

    static {
        a = new tv();
    }
}
