package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j extends SSettingKey<Boolean> {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
        Boolean r4 = Boolean.TRUE;
        super("live_add_first_screen_log", "添加首屏埋点", r4, r4, false);
    }
}
