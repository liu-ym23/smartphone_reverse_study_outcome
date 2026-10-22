package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r30 extends SSettingKey<Boolean> {
    public static final r30 a = null;

    static {
        a = new r30();
    }

    public r30() {
        Boolean r1 = Boolean.FALSE;
        super("live_is_load_gift_after_feed_end", "是否在直播Feed首刷后再加载资源", r1, r1);
    }
}
