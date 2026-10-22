package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e extends SSettingKey<Boolean> {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
        Boolean r1 = Boolean.FALSE;
        super("first_screen_debug_info", "直播间内首屏信息(调试用)", r1, r1);
    }
}
