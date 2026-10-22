package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l70 extends SettingKey<Boolean> {
    public static final l70 a = null;

    static {
        a = new l70();
    }

    public l70() {
        Boolean r1 = Boolean.TRUE;
        super("live_long_press_guide_opt", "LongPressGuideHelper.show()开关", r1, r1);
    }
}
