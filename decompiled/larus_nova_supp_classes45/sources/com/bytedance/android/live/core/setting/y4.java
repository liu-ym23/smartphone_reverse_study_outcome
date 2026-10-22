package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y4 extends SSettingKey<Boolean> {
    public static final y4 a = null;

    static {
        a = new y4();
    }

    public y4() {
        Boolean r1 = Boolean.TRUE;
        super("live_sei_pc_compatible_enable", "SEI处理兼容伴侣KTV逻辑", r1, r1);
    }
}
