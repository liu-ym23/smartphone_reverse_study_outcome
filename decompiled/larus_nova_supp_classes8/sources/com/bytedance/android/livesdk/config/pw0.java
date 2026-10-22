package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pw0 extends SSettingKey<Float> {
    public static final pw0 a = null;

    static {
        a = new pw0();
    }

    public pw0() {
        Float r0 = Float.valueOf(7.49f);
        super("live_video_avatar_performance_limit_anchor", "视频聊天室使用avatar最低机型打分要求-for主播", r0, r0);
    }
}
