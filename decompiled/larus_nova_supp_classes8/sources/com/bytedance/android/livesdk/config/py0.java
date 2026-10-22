package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class py0 extends SSettingKey<Boolean> {
    public static final py0 a = null;

    static {
        a = new py0();
    }

    public py0() {
        Boolean r1 = Boolean.TRUE;
        super("live_welfare_click_debounce_enable", "公益卡片点击debounce优化", r1, r1);
    }
}
