package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class kz0 extends SSettingKey<Boolean> {
    public static final kz0 a = null;

    static {
        a = new kz0();
    }

    public kz0() {
        Boolean r1 = Boolean.FALSE;
        super("live_wto_enable_jato_opt", "WTO框架是否支持Jato优化", r1, r1);
    }
}
