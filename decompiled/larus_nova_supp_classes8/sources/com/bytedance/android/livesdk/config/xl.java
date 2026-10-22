package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xl extends SSettingKey<Boolean> {
    public static final xl a = null;

    static {
        a = new xl();
    }

    public xl() {
        Boolean r1 = Boolean.FALSE;
        super("live_common_share_params_enable", "是否开启分享参数透传", r1, r1);
    }
}
