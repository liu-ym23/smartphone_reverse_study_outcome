package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c1 extends SSettingKey<Boolean> {
    public static final c1 a = null;

    static {
        a = new c1();
    }

    public c1() {
        boolean r0 = tb1.c.c;
        super("enable_short_touch_bubble", "短触气泡开关", Boolean.valueOf(r0), Boolean.valueOf(r0));
    }
}
