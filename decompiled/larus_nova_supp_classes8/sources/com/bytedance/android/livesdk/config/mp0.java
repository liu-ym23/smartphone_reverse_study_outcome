package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mp0 extends SettingKey<Boolean> {
    public static final mp0 a = null;

    static {
        a = new mp0();
    }

    public mp0() {
        Boolean r1 = Boolean.FALSE;
        super("live_rx_compat_share_opt", "RxCompat的share不走反射", r1, r1);
    }
}
