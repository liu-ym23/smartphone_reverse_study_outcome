package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i2 extends SSettingKey<Boolean> {
    public static final i2 a = null;

    static {
        a = new i2();
    }

    public i2() {
        Boolean r1 = Boolean.TRUE;
        super("live_load_short_touch_registe_log", "短触loadShortTouch上报", r1, r1);
    }
}
