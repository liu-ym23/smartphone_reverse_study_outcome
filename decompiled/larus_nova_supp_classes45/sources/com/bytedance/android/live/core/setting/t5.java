package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.config.setting.LiveDrawOverlayConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t5 extends SSettingKey<LiveDrawOverlayConfig> {
    public static final t5 a = null;

    static {
        a = new t5();
    }

    public t5() {
        super("live_viewgroup_draw_child_opt", "直播ViewGrooup子view绘制优化", new LiveDrawOverlayConfig(), new LiveDrawOverlayConfig());
    }
}
