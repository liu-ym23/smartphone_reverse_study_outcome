package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d4 extends SSettingKey<Boolean> {
    public static final d4 a = null;

    static {
        a = new d4();
    }

    public d4() {
        Boolean r1 = Boolean.FALSE;
        super("enable_read_setting_method_setting_cache", "ReadSettingMethod的setting缓存", r1, r1);
    }
}
