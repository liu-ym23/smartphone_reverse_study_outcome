package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gd1 extends SSettingKey<Long> {
    public static final gd1 a = null;

    static {
        a = new gd1();
    }

    public gd1() {
        super("paid_live_buy_module_click_threshold", "购票面板防抖动间隔", 800L, 800L);
    }
}
