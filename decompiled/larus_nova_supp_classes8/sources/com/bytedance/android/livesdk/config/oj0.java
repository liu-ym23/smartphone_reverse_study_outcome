package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.livetrace.LivePreviewTraceSettingConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class oj0 extends SSettingKey<LivePreviewTraceSettingConfig> {
    public static final oj0 a = null;

    static {
        a = new oj0();
    }

    public oj0() {
        super("live_preview_enable_live_trace", "直播预览流live trace开关", new LivePreviewTraceSettingConfig(), new LivePreviewTraceSettingConfig());
    }
}
