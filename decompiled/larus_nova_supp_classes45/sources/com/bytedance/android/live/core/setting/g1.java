package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g1 extends SSettingKey<Boolean> {
    public static final g1 a = null;

    static {
        a = new g1();
    }

    public g1() {
        Boolean r1 = Boolean.TRUE;
        super("live_enhanced_short_touch_animation_close", "强化短触区消失时关闭右移动画", r1, r1);
    }
}
