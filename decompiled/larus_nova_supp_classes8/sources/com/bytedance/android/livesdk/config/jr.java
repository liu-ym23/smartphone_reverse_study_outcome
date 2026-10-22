package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jr extends SSettingKey<Boolean> {
    public static final jr a = null;

    static {
        a = new jr();
    }

    public jr() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_show_distance_in_feed_drawer_city", "抽屉同城显示距离", r1, r1);
    }
}
