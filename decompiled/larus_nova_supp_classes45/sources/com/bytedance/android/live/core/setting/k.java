package com.bytedance.android.live.core.setting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k extends SettingKey<Float> {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
        Float r0 = Float.valueOf(7.5f);
        super("live_device_model_record_score", "针对主播端：主播当前机型的录制打分", r0, r0);
    }
}
