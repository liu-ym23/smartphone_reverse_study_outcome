package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vs extends SSettingKey<Boolean> {
    public static final vs a = null;

    static {
        a = new vs();
    }

    public vs() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_scale_video", "是否允许直播视频画面放大", r1, r1);
    }
}
