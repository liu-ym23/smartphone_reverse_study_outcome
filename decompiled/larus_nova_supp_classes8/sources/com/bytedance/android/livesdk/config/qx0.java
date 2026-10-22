package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qx0 extends SSettingKey<Boolean> {
    public static final qx0 a = null;

    static {
        a = new qx0();
    }

    public qx0() {
        Boolean r1 = Boolean.FALSE;
        super("live_vr_support_landscape", "VR新样式下，是否支持横屏看播", r1, r1);
    }
}
