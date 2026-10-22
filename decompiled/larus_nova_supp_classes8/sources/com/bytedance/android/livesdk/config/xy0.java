package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xy0 extends SSettingKey<j91> {
    public static final xy0 a = null;

    static {
        xy0 r0 = new xy0();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public xy0() {
        super("live_widget_priority_config", "widget优先级配置", new j91(), new j91());
    }
}
