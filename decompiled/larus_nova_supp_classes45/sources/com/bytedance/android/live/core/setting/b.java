package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends SSettingKey<Boolean> {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_net_hint", "弱网情况下是否弹toast", r1, r1);
    }
}
