package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class le extends SSettingKey<Boolean> {
    public static final le a = null;

    static {
        a = new le();
    }

    public le() {
        Boolean r1 = Boolean.FALSE;
        super("live_assets_async_preload_enable", "直播资源预热开关", r1, r1);
    }
}
