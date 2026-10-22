package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveReuseStreamAdaptLandScapeConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class li extends SSettingKey<LiveReuseStreamAdaptLandScapeConfig> {
    public static final li a = null;

    static {
        a = new li();
    }

    public li() {
        super("live_broadcast_start_reuse_stream_horization", "音画链路复用兼容横屏竖开", new LiveReuseStreamAdaptLandScapeConfig(), new LiveReuseStreamAdaptLandScapeConfig());
    }
}
