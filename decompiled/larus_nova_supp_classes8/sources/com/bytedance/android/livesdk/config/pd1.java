package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pd1 extends SSettingKey<Float> {
    public static final pd1 a = null;

    static {
        a = new pd1();
    }

    public pd1() {
        super("live_pk_top_spacing_ratio_addition", "PK合流画面离顶部距离diff", Float.valueOf(0.02f), Float.valueOf(0.0f));
    }
}
