package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gv0 extends SSettingKey<Float> {
    public static final gv0 a = null;

    static {
        a = new gv0();
    }

    public gv0() {
        Float r0 = Float.valueOf(0.24f);
        super("live_top_gradient_layer_alpha", "看播端竖屏上蒙层透明度", r0, r0);
    }
}
