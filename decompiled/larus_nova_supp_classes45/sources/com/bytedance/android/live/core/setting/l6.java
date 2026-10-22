package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l6 extends SSettingKey<Boolean> {
    public static final l6 a = null;

    static {
        a = new l6();
    }

    public l6() {
        Boolean r1 = Boolean.FALSE;
        super("mock_right_bottom_banner_size", "将右下角banner尺寸变大(调试用)", r1, r1);
    }
}
