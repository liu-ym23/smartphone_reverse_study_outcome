package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e5 extends SSettingKey<Boolean> {
    public static final e5 a = null;

    static {
        a = new e5();
    }

    public e5() {
        Boolean r1 = Boolean.TRUE;
        super("live_short_touch_insert_control", "短触区管控能力开关", r1, r1);
    }
}
