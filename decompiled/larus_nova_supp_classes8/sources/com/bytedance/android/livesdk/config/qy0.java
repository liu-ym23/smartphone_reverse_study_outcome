package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qy0 extends SSettingKey<ck1> {
    public static final qy0 a = null;

    static {
        qy0 r0 = new qy0();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public qy0() {
        super("live_welfare_opt_config", "公益组件配置", new ck1(), new ck1());
    }
}
