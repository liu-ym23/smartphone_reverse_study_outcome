package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l0 extends SSettingKey<Boolean> {
    public static final l0 a = null;

    static {
        a = new l0();
    }

    public l0() {
        Boolean r1 = Boolean.FALSE;
        super("live_disable_feed_back_freq", "屏蔽轻交互问卷端上频控逻辑(QA测试时可以打开，默认关的)", r1, r1);
    }
}
