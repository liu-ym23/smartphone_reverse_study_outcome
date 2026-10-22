package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class np0 extends SettingKey<Boolean> {
    public static final np0 a = null;

    static {
        a = new np0();
    }

    public np0() {
        Boolean r1 = Boolean.FALSE;
        super("live_saas_full_fuse_request_enable", "直播 saas 完全同构适配", r1, r1);
    }
}
