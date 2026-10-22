package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class tf extends SSettingKey<Boolean> {
    public static final tf a = null;

    static {
        a = new tf();
    }

    public tf() {
        Boolean r1 = Boolean.FALSE;
        super("live_backend_anchor_switch", "backend主播侧开关", r1, r1);
    }
}
