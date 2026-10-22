package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class kl extends SSettingKey<Boolean> {
    public static final kl a = null;

    static {
        kl r0 = new kl();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public kl() {
        Boolean r1 = Boolean.FALSE;
        super("live_cold_start_widget_load_opt", "冷启widget加载优化", r1, r1);
    }
}
