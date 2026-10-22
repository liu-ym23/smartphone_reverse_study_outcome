package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class df0 extends SSettingKey<Boolean> {
    public static final df0 a = null;

    static {
        a = new df0();
    }

    public df0() {
        Boolean r1 = Boolean.FALSE;
        super("live_paid_live_continue_timing_enable", "流暂停时是否继续倒计时", r1, r1);
    }
}
