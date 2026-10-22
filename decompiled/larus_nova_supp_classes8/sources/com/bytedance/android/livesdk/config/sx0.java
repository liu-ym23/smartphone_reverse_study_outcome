package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sx0 extends SSettingKey<Boolean> {
    public static final sx0 a = null;

    static {
        a = new sx0();
    }

    public sx0() {
        Boolean r1 = Boolean.FALSE;
        super("live_vr_use_new_style", "vr是否开启新UI&&新交互", r1, r1);
    }
}
