package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pw extends SettingKey<Boolean> {
    public static final pw a = null;

    static {
        a = new pw();
    }

    public pw() {
        Boolean r1 = Boolean.TRUE;
        super("live_fix_multi_camera_message_fetch_error", "修复横屏下切竖屏机位不断链的问题", r1, r1);
    }
}
