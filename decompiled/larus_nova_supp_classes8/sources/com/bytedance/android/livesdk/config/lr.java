package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lr extends SSettingKey<String> {
    public static final lr a = null;

    static {
        a = new lr();
    }

    public lr() {
        super("live_enable_dsl_template_force_mock", "直播dsl框架强制mock数据", "", "", false);
    }
}
