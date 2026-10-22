package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a6 extends SSettingKey<Boolean> {
    public static final a6 a = null;

    static {
        a = new a6();
    }

    public a6() {
        Boolean r1 = Boolean.TRUE;
        super("live_fix_timor_enable", "修复iOS主播开播小程序投屏安卓看播画面异常问题", r1, r1);
    }
}
