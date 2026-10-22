package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i00 extends SSettingKey<Boolean> {
    public static final i00 a = null;

    static {
        a = new i00();
    }

    public i00() {
        Boolean r1 = Boolean.FALSE;
        super("live_inner_feed_hot_refresh_ignore_data", "热更新丢弃返回结果", r1, r1);
    }
}
