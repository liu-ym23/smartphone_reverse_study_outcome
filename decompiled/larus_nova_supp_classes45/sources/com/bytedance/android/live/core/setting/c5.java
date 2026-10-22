package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c5 extends SSettingKey<Long> {
    public static final c5 a = null;

    static {
        a = new c5();
    }

    public c5() {
        super("live_short_touch_bigcard_time_out", "短触大卡的超时时长", 1000L, 1000L);
    }
}
