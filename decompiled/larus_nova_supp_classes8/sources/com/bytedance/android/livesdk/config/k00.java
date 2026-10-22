package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k00 extends SSettingKey<Integer> {
    public static final k00 a = null;

    static {
        a = new k00();
    }

    public k00() {
        super("live_inner_feed_hot_refresh_most_request_time", "内流热更新最小时间间隔", 10, 10);
    }
}
