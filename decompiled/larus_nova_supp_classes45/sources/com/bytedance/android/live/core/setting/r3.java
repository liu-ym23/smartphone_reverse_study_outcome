package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r3 extends SSettingKey<Boolean> {
    public static final r3 a = null;

    static {
        a = new r3();
    }

    public r3() {
        super("live_performance_miss_fix", "直播性能埋点丢失修复", Boolean.FALSE, Boolean.TRUE);
    }
}
