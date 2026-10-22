package com.bytedance.android.live.core.setting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p extends SettingKey<Float> {
    public static final p a = null;

    static {
        p r0 = new p();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public p() {
        Float r0 = Float.valueOf(7.5f);
        super("live_device_model_overall_score", "针对观众端：观众当前机型的综合打分", r0, r0);
    }
}
