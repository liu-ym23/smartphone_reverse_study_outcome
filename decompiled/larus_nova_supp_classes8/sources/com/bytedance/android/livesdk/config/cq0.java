package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class cq0 extends SettingKey<Boolean> {
    public static final cq0 a = null;

    static {
        a = new cq0();
    }

    public cq0() {
        Boolean r1 = Boolean.FALSE;
        super("live_screencast_close_activity_enable", "录屏开播关闭无用activity", r1, r1);
    }
}
