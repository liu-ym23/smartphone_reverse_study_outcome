package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lp0 extends SSettingKey<Boolean> {
    public static final lp0 a = null;

    static {
        lp0 r0 = new lp0();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public lp0() {
        super("live_rts_preload_setting", "RTS信令预加载", Boolean.FALSE, Boolean.TRUE, new String[]{"true:使用预加载", "false:不使用预加载"});
    }
}
