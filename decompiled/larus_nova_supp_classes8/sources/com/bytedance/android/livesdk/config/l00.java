package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l00 extends SSettingKey<Integer> {
    public static final l00 a = null;

    static {
        a = new l00();
    }

    public l00() {
        super("live_inner_feed_hot_refresh_stay_time", "单个直播间停留时长触发热更新", 180, 180);
    }
}
