package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h2 extends SSettingKey<Boolean> {
    public static final h2 a = null;

    static {
        a = new h2();
    }

    public h2() {
        Boolean r1 = Boolean.TRUE;
        super("live_load_short_touch_bigcard_anim_enable", "短触大卡动画单独打开", r1, r1);
    }
}
