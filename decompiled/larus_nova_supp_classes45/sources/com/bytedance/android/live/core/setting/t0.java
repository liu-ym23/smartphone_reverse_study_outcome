package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t0 extends SSettingKey<Boolean> {
    public static final t0 a = null;

    static {
        a = new t0();
    }

    public t0() {
        Boolean r1 = Boolean.FALSE;
        super("live_dynamic_unregister_message_enable", "动态化解注册message", r1, r1);
    }
}
