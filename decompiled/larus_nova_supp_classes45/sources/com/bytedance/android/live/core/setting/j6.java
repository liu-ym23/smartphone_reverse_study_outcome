package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j6 extends SSettingKey<Boolean> {
    public static final j6 a = null;

    static {
        a = new j6();
    }

    public j6() {
        Boolean r1 = Boolean.TRUE;
        super("live_vs_reset_video_bottom_for_vertical", "节目直播竖版重置video_bottom", r1, r1);
    }
}
