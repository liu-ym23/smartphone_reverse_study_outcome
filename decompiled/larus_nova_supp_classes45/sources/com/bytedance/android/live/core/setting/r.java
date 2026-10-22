package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r extends SSettingKey<Boolean> {
    public static final r a = null;

    static {
        a = new r();
    }

    public r() {
        Boolean r1 = Boolean.TRUE;
        super("live_background_notification_enable", "语音直播后台播放通知开关", r1, r1);
    }
}
