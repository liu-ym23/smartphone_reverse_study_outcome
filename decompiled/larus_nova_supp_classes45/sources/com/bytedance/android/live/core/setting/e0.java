package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e0 extends SSettingKey<Boolean> {
    public static final e0 a = null;

    static {
        a = new e0();
    }

    public e0() {
        Boolean r1 = Boolean.FALSE;
        super("live_community_tracking_fix", "社区埋点修复", r1, r1);
    }
}
