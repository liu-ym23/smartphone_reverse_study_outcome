package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ew0 extends SSettingKey<Boolean> {
    public static final ew0 a = null;

    static {
        a = new ew0();
    }

    public ew0() {
        Boolean r4 = Boolean.FALSE;
        super("live_user_profile_request_retrofit_opt", "user/profile接口retrofit优化", r4, r4, true);
    }
}
