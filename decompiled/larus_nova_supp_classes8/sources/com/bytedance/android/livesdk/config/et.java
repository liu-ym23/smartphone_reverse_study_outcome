package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class et extends SSettingKey<Boolean> {
    public static final et a = null;

    static {
        a = new et();
    }

    public et() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_slide_optimize", "是否开启上下滑优化", r1, r1);
    }
}
