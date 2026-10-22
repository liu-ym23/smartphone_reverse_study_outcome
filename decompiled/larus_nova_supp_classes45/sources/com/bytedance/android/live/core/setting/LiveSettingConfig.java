package com.bytedance.android.live.core.setting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
interface LiveSettingConfig {
    public static final SettingKey<Boolean> LIVE_ENABLE_SETTING_MONITOR = null;

    static {
        Boolean r4 = Boolean.TRUE;
        LIVE_ENABLE_SETTING_MONITOR = new SettingKey("live_enable_setting_guard_monitor", "是否上报setting流程中的异常", r4, r4, true);
    }
}
