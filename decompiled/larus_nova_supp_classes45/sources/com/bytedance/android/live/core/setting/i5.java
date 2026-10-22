package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i5 extends SSettingKey<Boolean> {
    public static final i5 a = null;

    static {
        a = new i5();
    }

    public i5() {
        super("live_smooth_enter_feed_sv_opt", "平滑进房SurfaceView黑屏优化", Boolean.FALSE, Boolean.TRUE);
    }
}
