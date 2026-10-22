package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b5 extends SSettingKey<Boolean> {
    public static final b5 a = null;

    static {
        a = new b5();
    }

    public b5() {
        Boolean r1 = Boolean.FALSE;
        super("live_short_touch_accessibility", "短触图标无障碍开关", r1, r1);
    }
}
