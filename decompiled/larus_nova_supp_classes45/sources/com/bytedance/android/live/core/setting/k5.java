package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k5 extends SSettingKey<Boolean> {
    public static final k5 a = null;

    static {
        a = new k5();
    }

    public k5() {
        Boolean r1 = Boolean.TRUE;
        super("live_stream_stall_switch", "直播流卡特征", r1, r1);
    }
}
