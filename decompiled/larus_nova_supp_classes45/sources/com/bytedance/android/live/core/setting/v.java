package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v extends SSettingKey<Integer> {
    public static final v a = null;

    public v() {
        super("live_audio_foreground_service_type_opt", "优化AudioLiveService的ANR", 0, 2);
    }

    static {
        a = new v();
    }
}
