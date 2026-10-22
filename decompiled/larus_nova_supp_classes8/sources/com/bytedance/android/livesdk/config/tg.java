package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class tg extends SSettingKey<Float> {
    public static final tg a = null;

    static {
        a = new tg();
    }

    public tg() {
        Float r0 = Float.valueOf(0.3f);
        super("live_bottom_gradient_layer_alpha", "看播端竖屏下蒙层透明度", r0, r0);
    }
}
