package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.AnchorVStreamPerfConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class im extends SSettingKey<AnchorVStreamPerfConfig> {
    public static final im a = null;

    static {
        a = new im();
    }

    public im() {
        super("live_anchor_video_stream_monitor", "LiveCore性能回调", new AnchorVStreamPerfConfig(), new AnchorVStreamPerfConfig(), true);
    }
}
