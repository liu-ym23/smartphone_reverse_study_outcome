package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bq extends SSettingKey<Boolean> {
    public static final bq a = null;

    static {
        bq r0 = new bq();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public bq() {
        super("live_dynamic_toolbar_modify_theme", Boolean.FALSE, "toolbar标准化换肤能力");
    }
}
