package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bq0 extends SettingKey<Boolean> {
    public static final bq0 a = null;

    static {
        a = new bq0();
    }

    public bq0() {
        Boolean r1 = Boolean.FALSE;
        super("live_screencast_capture_monitor_enable", "录屏开播推流内容监控", r1, r1);
    }
}
