package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x0 extends SSettingKey<Boolean> {
    public static final x0 a = null;

    static {
        a = new x0();
    }

    public x0() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_activity_tea_monitor", "允许活动区 tea 上报", r1, r1);
    }
}
