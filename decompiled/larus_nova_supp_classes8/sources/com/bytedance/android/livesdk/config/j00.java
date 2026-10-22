package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j00 extends SSettingKey<Float> {
    public static final j00 a = null;

    static {
        a = new j00();
    }

    public j00() {
        Float r0 = Float.valueOf(1.0f);
        super("live_inner_feed_hot_refresh_random_request_rate", "内流热更新概率", r0, r0);
    }
}
