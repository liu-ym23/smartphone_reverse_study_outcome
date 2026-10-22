package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o2 extends SSettingKey<Boolean> {
    public static final o2 a = null;

    static {
        a = new o2();
    }

    public o2() {
        Boolean r1 = Boolean.TRUE;
        super("live_mob_inject_pad_global_params", "是否给直播埋点注入pad全局参数", r1, r1);
    }
}
