package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jn extends SSettingKey<Float> {
    public static final jn a = null;

    static {
        a = new jn();
    }

    public jn() {
        Float r0 = Float.valueOf(0.3f);
        super("live_digg_frequence", "点赞动画丢弃概率，用来控制密度，0～1.0", r0, r0);
    }
}
