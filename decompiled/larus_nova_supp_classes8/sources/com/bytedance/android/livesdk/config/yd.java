package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class yd extends SSettingKey<Boolean> {
    public static final yd a = null;

    static {
        a = new yd();
    }

    public yd() {
        Boolean r1 = Boolean.FALSE;
        super("show_publish_announce_video_entrance", "直播预告后自动发视频预告", r1, r1);
    }
}
