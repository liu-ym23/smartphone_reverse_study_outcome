package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dn0 extends SSettingKey<Boolean> {
    public static final dn0 a = null;

    static {
        a = new dn0();
    }

    public dn0() {
        Boolean r4 = Boolean.TRUE;
        super("live_reset_dynamic_from_audience", "在LinkMultiControlWidget中重置dynamicFromAudience", r4, r4, true);
    }
}
