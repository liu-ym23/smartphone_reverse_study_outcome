package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q extends SSettingKey<Boolean> {
    public static final q a = null;

    static {
        a = new q();
    }

    public q() {
        Boolean r1 = Boolean.TRUE;
        super("live_audio_and_video_permission_test_enable", "音视频权限自动化测试环境上报", r1, r1);
    }
}
