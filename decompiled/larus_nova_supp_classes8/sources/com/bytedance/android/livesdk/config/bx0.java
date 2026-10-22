package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bx0 extends SSettingKey<Float> {
    public static final bx0 a = null;

    static {
        a = new bx0();
    }

    public bx0() {
        Float r0 = Float.valueOf(7.09f);
        super("live_video_ktv_performance_limit", "视频聊天室开启ktv最低机型打分要求", r0, r0);
    }
}
