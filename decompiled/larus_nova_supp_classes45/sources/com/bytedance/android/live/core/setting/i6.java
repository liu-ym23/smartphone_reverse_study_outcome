package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i6 extends SSettingKey<Boolean> {
    public static final i6 a = null;

    static {
        a = new i6();
    }

    public i6() {
        Boolean r1 = Boolean.TRUE;
        super("live_vs_optimize_buy_vip_toast", "会员进房付费直播toast文案", r1, r1);
    }
}
