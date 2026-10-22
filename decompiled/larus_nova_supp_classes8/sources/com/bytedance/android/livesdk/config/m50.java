package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m50 extends SSettingKey<d51> {
    public static final m50 a = null;

    static {
        m50 r0 = new m50();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public m50() {
        super("live_landscape_opt_config", "横屏体验框架优化配置", new d51(), new d51());
    }
}
