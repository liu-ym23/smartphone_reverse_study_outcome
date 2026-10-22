package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.setting.LivePreviewDanmakuConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lk0 extends SSettingKey<LivePreviewDanmakuConfig> {
    public static final lk0 a = null;

    static {
        a = new lk0();
    }

    public lk0() {
        super("live_pre_stream_danmaku_config", "直播预流弹幕配置", new LivePreviewDanmakuConfig(), new LivePreviewDanmakuConfig());
    }
}
