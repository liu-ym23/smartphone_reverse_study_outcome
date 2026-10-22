package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class zm0 extends SSettingKey<Boolean> {
    public static final zm0 a = null;

    static {
        a = new zm0();
    }

    public zm0() {
        Boolean r1 = Boolean.TRUE;
        super("live_reset_has_bgm_flag", "演唱结束需要重置hasBgm", r1, r1);
    }
}
