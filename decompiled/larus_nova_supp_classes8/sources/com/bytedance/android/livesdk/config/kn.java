package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class kn extends SSettingKey<Float> {
    public static final kn a = null;

    static {
        a = new kn();
    }

    public kn() {
        Float r0 = Float.valueOf(0.4f);
        super("live_digg_frequence_all", "点赞动画丢弃概率，用来控制密度（全局），0～1.0", r0, r0);
    }
}
