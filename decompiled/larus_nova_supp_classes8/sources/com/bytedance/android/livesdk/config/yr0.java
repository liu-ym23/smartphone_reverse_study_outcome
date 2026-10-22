package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class yr0 extends SettingKey<Boolean> {
    public static final yr0 a = null;

    static {
        a = new yr0();
    }

    public yr0() {
        Boolean r1 = Boolean.TRUE;
        super("live_share_to_daily_convert_error_value_enable", "检查异常值", r1, r1);
    }
}
