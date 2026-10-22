package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dt extends SSettingKey<Boolean> {
    public static final dt a = null;

    static {
        a = new dt();
    }

    public dt() {
        super("live_enable_show_unused_effect_label", Boolean.FALSE, "主播是否上报无美颜字段(用于观众端展示无美颜)");
    }
}
