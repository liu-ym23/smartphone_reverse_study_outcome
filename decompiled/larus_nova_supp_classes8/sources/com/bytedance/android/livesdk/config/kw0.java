package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class kw0 extends SSettingKey<Boolean> {
    public static final kw0 a = null;

    static {
        a = new kw0();
    }

    public kw0() {
        Boolean r1 = Boolean.TRUE;
        super("live_value_animator_scale_enable", "重置ValueAnimator中的DurationScale", r1, r1);
    }
}
