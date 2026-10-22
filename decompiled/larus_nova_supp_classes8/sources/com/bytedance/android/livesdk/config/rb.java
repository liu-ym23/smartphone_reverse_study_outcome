package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class rb extends SSettingKey<Boolean> {
    public static final rb a = null;

    static {
        a = new rb();
    }

    public rb() {
        Boolean r1 = Boolean.FALSE;
        super("live_anchor_enable_video_mock_push_stream", "支持视频mock推流", r1, r1);
    }
}
