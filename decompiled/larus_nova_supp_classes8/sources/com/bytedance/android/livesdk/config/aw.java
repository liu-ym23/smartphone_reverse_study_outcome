package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.FirstScreenOptConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class aw extends SSettingKey<FirstScreenOptConfig> {
    public static final aw a = null;

    static {
        a = new aw();
    }

    public aw() {
        super("live_first_screen_opt", "首屏组件加载优化", new FirstScreenOptConfig(), new FirstScreenOptConfig());
    }
}
