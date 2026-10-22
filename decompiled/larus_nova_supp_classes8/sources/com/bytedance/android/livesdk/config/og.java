package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class og extends SSettingKey<Boolean> {
    public static final og a = null;

    static {
        a = new og();
    }

    public og() {
        Boolean r1 = Boolean.TRUE;
        super("live_bottom_banner_manager_fix", "右下角banner crash fix", r1, r1);
    }
}
