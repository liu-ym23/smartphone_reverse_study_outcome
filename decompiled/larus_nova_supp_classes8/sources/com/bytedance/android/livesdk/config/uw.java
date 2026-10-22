package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class uw extends SSettingKey<Boolean> {
    public static final uw a = null;

    static {
        a = new uw();
    }

    public uw() {
        Boolean r1 = Boolean.FALSE;
        super("live_fix_service_exception_anr", "修复service找不到导致的ANR", r1, r1);
    }
}
