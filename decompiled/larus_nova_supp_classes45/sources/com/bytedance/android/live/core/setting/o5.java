package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o5 extends SSettingKey<Boolean> {
    public static final o5 a = null;

    static {
        a = new o5();
    }

    public o5() {
        Boolean r1 = Boolean.FALSE;
        super("live_useless_log_opt", "移除耗时的无用日志", r1, r1);
    }
}
