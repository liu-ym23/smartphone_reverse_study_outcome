package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z3 extends SSettingKey<Boolean> {
    public static final z3 a = null;

    static {
        a = new z3();
    }

    public z3() {
        Boolean r4 = Boolean.TRUE;
        super("live_preload_api_check_room_init", "判断init", r4, r4, true);
    }
}
