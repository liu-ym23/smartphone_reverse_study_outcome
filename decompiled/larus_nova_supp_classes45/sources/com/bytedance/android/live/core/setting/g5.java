package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g5 extends SSettingKey<Boolean> {
    public static final g5 a = null;

    static {
        a = new g5();
    }

    public g5() {
        Boolean r1 = Boolean.FALSE;
        super("live_short_touch_queue_expand_animation", "短触区排队放大动画", r1, r1);
    }
}
