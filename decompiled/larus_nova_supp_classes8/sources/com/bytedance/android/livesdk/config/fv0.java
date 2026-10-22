package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ToolbarShowOptConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fv0 extends SSettingKey<ToolbarShowOptConfig> {
    public static final fv0 a = null;

    static {
        a = new fv0();
    }

    public fv0() {
        super("live_toolbar_show_opt", new ToolbarShowOptConfig(), "toolbar展示优化");
    }
}
