package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wx0 extends SSettingKey<Float> {
    public static final wx0 a = null;

    static {
        a = new wx0();
    }

    public wx0() {
        Float r0 = Float.valueOf(7.09f);
        super("live_vs_inside_record_performance_limit", "直播录屏最低机型打分要求", r0, r0);
    }
}
