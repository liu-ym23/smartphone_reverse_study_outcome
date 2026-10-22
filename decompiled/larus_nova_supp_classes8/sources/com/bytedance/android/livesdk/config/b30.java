package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b30 extends SSettingKey<Boolean> {
    public static final b30 a = null;

    static {
        a = new b30();
    }

    public b30() {
        Boolean r1 = Boolean.FALSE;
        super("live_anchor_enable_interact_panel_count_limit", "互动工具是否支持多开", r1, r1);
    }
}
