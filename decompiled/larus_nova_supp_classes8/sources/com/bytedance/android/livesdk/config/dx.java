package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dx extends SSettingKey<Boolean> {
    public static final dx a = null;

    static {
        a = new dx();
    }

    public dx() {
        Boolean r1 = Boolean.FALSE;
        super("live_float_window_return_opt_enable", "小窗返回优化配置", r1, r1);
    }
}
