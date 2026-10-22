package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class iq extends SSettingKey<Long> {
    public static final iq a = null;

    static {
        a = new iq();
    }

    public iq() {
        super("live_ec_shop_cart_loop_time", "工具栏动效间隔时间（调试用）", 60L, 60L);
    }
}
