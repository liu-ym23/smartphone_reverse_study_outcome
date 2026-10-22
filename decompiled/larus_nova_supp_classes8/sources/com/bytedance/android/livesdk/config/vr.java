package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vr extends SSettingKey<Boolean> {
    public static final vr a = null;

    static {
        a = new vr();
    }

    public vr() {
        Boolean r1 = Boolean.FALSE;
        super("live_gradient_adaptive_enable", "直播间蒙层透明度自适应", r1, r1);
    }
}
