package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class el0 extends SSettingKey<Boolean> {
    public static final el0 a = null;

    static {
        a = new el0();
    }

    public el0() {
        Boolean r1 = Boolean.TRUE;
        super("live_ps_video_share_show_enable", "公屏是否支持视频分享消息的显示", r1, r1);
    }
}
