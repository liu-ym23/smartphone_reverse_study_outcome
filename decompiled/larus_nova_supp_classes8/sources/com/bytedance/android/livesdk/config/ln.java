package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ln extends SSettingKey<ss1.c> {
    public static final ln a = null;

    static {
        ln r0 = new ln();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public ln() {
        super("live_digg_anim_opt_config", "点赞动画优化开关", new ss1.c(), new ss1.c());
    }
}
