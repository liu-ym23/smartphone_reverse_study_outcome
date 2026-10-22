package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x3 extends SSettingKey<Boolean> {
    public static final x3 a = null;

    static {
        a = new x3();
    }

    public x3() {
        Boolean r1 = Boolean.TRUE;
        super("live_play_together_toolbar_opt", "适用于一起玩场景下的toolbar优化的端上兜底总开关", r1, r1);
    }
}
