package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gr0 extends SSettingKey<Boolean> {
    public static final gr0 a = null;

    static {
        a = new gr0();
    }

    public gr0() {
        Boolean r1 = Boolean.TRUE;
        super("live_security_text_correction", "是否纠错", r1, r1);
    }
}
