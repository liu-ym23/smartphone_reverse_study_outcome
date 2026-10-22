package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class kt extends SettingKey<Boolean> {
    public static final kt a = null;

    static {
        a = new kt();
    }

    public kt() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_timon_calendar", "是否使用Timon的日历功能", r1, r1);
    }
}
