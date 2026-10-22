package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a2 extends SSettingKey<Boolean> {
    public static final a2 a = null;

    static {
        a = new a2();
    }

    public a2() {
        Boolean r1 = Boolean.FALSE;
        super("live_interact_audio_capture_background_anchor", "主播侧退后台是否采集音频", r1, r1);
    }
}
