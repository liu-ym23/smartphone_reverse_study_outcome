package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a80 extends SSettingKey<Boolean> {
    public static final a80 a = null;

    static {
        a = new a80();
    }

    public a80() {
        Boolean r1 = Boolean.FALSE;
        super("live_mcu_test_fall_back", "跨房厅战公共流超时回退跨房流测试", r1, r1);
    }
}
