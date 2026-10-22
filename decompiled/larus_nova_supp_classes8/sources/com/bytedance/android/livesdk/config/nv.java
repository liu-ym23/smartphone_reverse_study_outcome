package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nv extends SSettingKey<Boolean> {
    public static final nv a = null;

    static {
        a = new nv();
    }

    public nv() {
        Boolean r1 = Boolean.FALSE;
        super("live_feedback_payment_behavior", "直播间付费引导问卷强插内流和预览流的开关", r1, r1);
    }
}
