package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class kx extends SSettingKey<h31> {
    public static final kx a = null;

    static {
        kx r0 = new kx();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public kx() {
        super("live_follow_empty_recommend_guide_config", "关注页直播内流刷空时引导看推荐直播", new h31(), new h31());
    }
}
