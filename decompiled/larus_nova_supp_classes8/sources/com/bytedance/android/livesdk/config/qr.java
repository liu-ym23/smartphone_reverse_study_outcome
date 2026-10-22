package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qr extends SSettingKey<Integer> {
    public static final qr a = null;

    public qr() {
        super("live_enable_feed_request_with_extra", "直播feed是否上报更多信息", 0, 0);
    }

    static {
        a = new qr();
    }
}
