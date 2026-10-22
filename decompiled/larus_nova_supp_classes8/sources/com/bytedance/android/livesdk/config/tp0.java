package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class tp0 extends SSettingKey<Boolean> {
    public static final tp0 a = null;

    static {
        a = new tp0();
    }

    public tp0() {
        Boolean r1 = Boolean.TRUE;
        super("live_scale_video_in_multi_people_enable", "是否允许PK直播视频画面放大", r1, r1);
    }
}
