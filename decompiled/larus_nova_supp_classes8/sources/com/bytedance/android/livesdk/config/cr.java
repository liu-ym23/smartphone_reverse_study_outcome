package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class cr extends SettingKey<Boolean> {
    public static final cr a = null;

    static {
        a = new cr();
    }

    public cr() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_block_user_optimize", "看播拉黑校验", r1, r1);
    }
}
