package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w5 extends SSettingKey<Boolean> {
    public static final w5 a = null;

    static {
        a = new w5();
    }

    public w5() {
        Boolean r1 = Boolean.TRUE;
        super("live_vr_top_margin_fix", "VR沉浸模式下顶部间距修复", r1, r1);
    }
}
