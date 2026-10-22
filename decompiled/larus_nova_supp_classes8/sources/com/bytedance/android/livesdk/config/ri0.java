package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ri0 extends SSettingKey<Boolean> {
    public static final ri0 a = null;

    static {
        a = new ri0();
    }

    public ri0() {
        Boolean r1 = Boolean.FALSE;
        super("live_play_brightness_track_enable", "播放亮度信息埋点上报", r1, r1);
    }
}
