package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c3 extends SSettingKey<Boolean> {
    public static final c3 a = null;

    static {
        a = new c3();
    }

    public c3() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_link_radio_support_lynx_avatar", "电台头像lynx化", r1, r1);
    }
}
