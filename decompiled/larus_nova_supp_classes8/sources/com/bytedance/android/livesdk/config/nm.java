package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nm extends SSettingKey<Boolean> {
    public static final nm a = null;

    static {
        a = new nm();
    }

    public nm() {
        Boolean r1 = Boolean.TRUE;
        super("live_cross_room_disable_mp4_background", "跨房语音vs视频直播间关闭mp4背景播放", r1, r1);
    }
}
