package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s5 extends SSettingKey<Boolean> {
    public static final s5 a = null;

    static {
        a = new s5();
    }

    public s5() {
        Boolean r1 = Boolean.FALSE;
        super("live_use_short_touch_dismiss_animation", "使用短触区退出动画", r1, r1);
    }
}
