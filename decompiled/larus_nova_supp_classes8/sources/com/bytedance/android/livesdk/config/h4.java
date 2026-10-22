package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h4 extends SSettingKey<Boolean> {
    public static final h4 a = null;

    static {
        a = new h4();
    }

    public h4() {
        Boolean r1 = Boolean.FALSE;
        super("enable_setting_state_value_cache", "SettingState的setting缓存", r1, r1);
    }
}
