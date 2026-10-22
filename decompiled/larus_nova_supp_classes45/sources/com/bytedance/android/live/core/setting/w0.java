package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w0 extends SSettingKey<Boolean> {
    public static final w0 a = null;

    static {
        a = new w0();
    }

    public w0() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_activity_slardar_monitor", "允许活动区 sladar 上报", r1, r1);
    }
}
