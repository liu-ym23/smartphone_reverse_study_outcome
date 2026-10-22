package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p0 extends SSettingKey<Boolean> {
    public static final p0 a = null;

    static {
        a = new p0();
    }

    public p0() {
        Boolean r1 = Boolean.FALSE;
        super("live_dynamic_opt_anniex_enable", "直播短触区切换AnnieX极简卡开关", r1, r1);
    }
}
