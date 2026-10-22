package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveViewInflateConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gx0 extends SSettingKey<LiveViewInflateConfig> {
    public static final gx0 a = null;

    static {
        a = new gx0();
    }

    public gx0() {
        super("live_view_inflate_opt", "直播内流View预加载", new LiveViewInflateConfig(), new LiveViewInflateConfig());
    }
}
