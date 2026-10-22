package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ei0 extends SSettingKey<Boolean> {
    public static final ei0 a = null;

    static {
        a = new ei0();
    }

    public ei0() {
        Boolean r1 = Boolean.TRUE;
        super("live_player_screen_record_scale_type", "预览流录屏直播scaleType替换", r1, r1);
    }
}
