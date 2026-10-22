package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class up0 extends SSettingKey<Boolean> {
    public static final up0 a = null;

    static {
        a = new up0();
    }

    public up0() {
        Boolean r1 = Boolean.TRUE;
        super("live_scale_xy_ratio_on_mobile", "直播ViewCropper在移动端仅使用scaleXY进行等比例缩放", r1, r1);
    }
}
