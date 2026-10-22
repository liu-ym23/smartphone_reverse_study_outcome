package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ux0 extends SettingKey<Boolean> {
    public static final ux0 a = null;

    static {
        a = new ux0();
    }

    public ux0() {
        Boolean r1 = Boolean.TRUE;
        super("live_vs_enable_ugc_interactive", "", r1, r1);
    }
}
