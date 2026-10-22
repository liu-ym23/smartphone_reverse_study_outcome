package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i1 extends SSettingKey<Boolean> {
    public static final i1 a = null;

    static {
        a = new i1();
    }

    public i1() {
        Boolean r4 = Boolean.TRUE;
        super("live_external_fragment_state_fix", "fix接入层fragment状态异常问题", r4, r4, true);
    }
}
