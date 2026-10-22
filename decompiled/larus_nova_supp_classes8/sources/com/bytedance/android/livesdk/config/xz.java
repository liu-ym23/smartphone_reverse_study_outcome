package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xz extends SSettingKey<Boolean> {
    public static final xz a = null;

    static {
        a = new xz();
    }

    public xz() {
        Boolean r1 = Boolean.TRUE;
        super("live_hamlet_avatar_v2_enable_rtc_video_enhance", "hamlet avata二期是否支持画质增强(rtc)", r1, r1);
    }
}
