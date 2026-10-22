package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j1 extends SSettingKey<Boolean> {
    public static final j1 a = null;

    static {
        a = new j1();
    }

    public j1() {
        Boolean r4 = Boolean.TRUE;
        super("live_external_fragment_visible_fix", "fix接入层fragment状态异常问题", r4, r4, true);
    }
}
