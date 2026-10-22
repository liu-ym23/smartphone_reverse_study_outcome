package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n5 extends SSettingKey<Boolean> {
    public static final n5 a = null;

    static {
        a = new n5();
    }

    public n5() {
        Boolean r1 = Boolean.FALSE;
        super("live_test_short_touch", "短触测试", r1, r1);
    }
}
