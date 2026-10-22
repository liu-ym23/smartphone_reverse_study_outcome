package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h6 extends SSettingKey<Boolean> {
    public static final h6 a = null;

    static {
        a = new h6();
    }

    public h6() {
        Boolean r1 = Boolean.TRUE;
        super("live_vs_fix_multi_tab_pad_landscape_hide", "pad横屏多tab不消失", r1, r1);
    }
}
