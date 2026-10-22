package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u4 extends SSettingKey<Boolean> {
    public static final u4 a = null;

    static {
        a = new u4();
    }

    public u4() {
        Boolean r1 = Boolean.FALSE;
        super("live_room_indicator_enable_dialog", "右上角通用指示器是否支持点击出弹窗", r1, r1);
    }
}
