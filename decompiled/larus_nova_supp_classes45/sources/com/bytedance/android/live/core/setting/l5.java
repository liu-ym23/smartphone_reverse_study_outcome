package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l5 extends SSettingKey<Boolean> {
    public static final l5 a = null;

    static {
        a = new l5();
    }

    public l5() {
        Boolean r1 = Boolean.FALSE;
        super("live_support_activity_touch_dispatch", "直播Acitvity支持事件分发", r1, r1);
    }
}
