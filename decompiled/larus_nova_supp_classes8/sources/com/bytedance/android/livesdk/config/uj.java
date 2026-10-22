package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class uj extends SSettingKey<ng2.b> {
    public static final uj a = null;

    static {
        uj r0 = new uj();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public uj() {
        super("live_enable_open_topic", "直播支持话题AB", new ng2.b(), new ng2.b());
    }
}
