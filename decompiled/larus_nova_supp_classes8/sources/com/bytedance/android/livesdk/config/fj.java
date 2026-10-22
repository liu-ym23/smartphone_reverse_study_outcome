package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fj extends SettingKey<Boolean> {
    public static final fj a = null;

    static {
        a = new fj();
    }

    public fj() {
        Boolean r4 = Boolean.FALSE;
        super("live_camera_switch_log_enable", "直播相机切换日志", r4, r4, true);
    }
}
