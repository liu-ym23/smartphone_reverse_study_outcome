package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.DSConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qp extends SSettingKey<DSConfig> {
    public static final qp a = null;

    static {
        a = new qp();
    }

    public qp() {
        super("live_ds_guide_animation_config", "ds 直播间公屏区引导动画", new DSConfig(), new DSConfig());
    }
}
