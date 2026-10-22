package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u40 extends SSettingKey<Long> {
    public static final u40 a = null;

    static {
        a = new u40();
    }

    public u40() {
        super("live_ktv_open_camera_count_down_time", "ktv开启视频画面延迟时间（单位毫秒）", 3000L, 3000L);
    }
}
