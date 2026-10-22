package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ax0 extends SSettingKey<Boolean> {
    public static final ax0 a = null;

    static {
        a = new ax0();
    }

    public ax0() {
        super("live_video_ktv_enable", "视频KTV入口AB", Boolean.FALSE, Boolean.TRUE);
    }
}
