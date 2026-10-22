package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.HalfScreenBackgroundConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x1 extends SSettingKey<HalfScreenBackgroundConfig> {
    public static final x1 a = null;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.android.live.core.setting.SettingKey, com.bytedance.android.live.core.setting.x1] */
    static {
        ?? r0 = new x1();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public x1() {
        super("live_half_screen_background_opt", "半屏流背景图优化", new HalfScreenBackgroundConfig(), new HalfScreenBackgroundConfig());
    }
}
