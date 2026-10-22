package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class kg extends SSettingKey<Boolean> {
    public static final kg a = null;

    static {
        a = new kg();
    }

    public kg() {
        Boolean r1 = Boolean.FALSE;
        super("live_block_code_opt", "比较零散的耗时逻辑优化", r1, r1);
    }
}
