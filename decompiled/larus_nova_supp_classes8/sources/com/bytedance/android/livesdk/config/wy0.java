package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveWidgetLoadOptConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wy0 extends SSettingKey<LiveWidgetLoadOptConfig> {
    public static final wy0 a = null;

    static {
        a = new wy0();
    }

    public wy0() {
        super("live_widget_load_condition_opt", "进房组件加载逻辑优化", new LiveWidgetLoadOptConfig(), new LiveWidgetLoadOptConfig());
    }
}
