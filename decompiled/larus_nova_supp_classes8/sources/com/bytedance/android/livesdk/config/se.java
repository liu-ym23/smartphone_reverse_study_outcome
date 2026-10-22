package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class se extends SettingKey<Float> {
    public static final se a = null;

    static {
        se r0 = new se();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public se() {
        Float r0 = Float.valueOf(7.5f);
        super("live_device_model_overall_score", "针对观众端：观众当前机型的综合打分", r0, r0);
    }
}
