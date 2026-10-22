package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h00 extends SSettingKey<Boolean> {
    public static final h00 a = null;

    static {
        a = new h00();
    }

    public h00() {
        Boolean r1 = Boolean.FALSE;
        super("live_inner_feed_hot_refresh", "是否开启热更新", r1, r1);
    }
}
