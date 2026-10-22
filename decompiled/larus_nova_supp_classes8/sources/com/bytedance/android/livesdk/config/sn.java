package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sn extends SSettingKey<Boolean> {
    public static final sn a = null;

    static {
        a = new sn();
    }

    public sn() {
        Boolean r1 = Boolean.TRUE;
        super("live_digit_avatar_mute_video_stream_proc_switch", "视频连线Avatar mute视频流", r1, r1);
    }
}
