package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z4 extends SSettingKey<Boolean> {
    public static final z4 a = null;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.android.live.core.setting.SettingKey, com.bytedance.android.live.core.setting.z4] */
    static {
        ?? r0 = new z4();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public z4() {
        Boolean r1 = Boolean.FALSE;
        super("live_setting_applog_key", "拉流端播放器日志是否使用applog上报", r1, r1);
    }
}
