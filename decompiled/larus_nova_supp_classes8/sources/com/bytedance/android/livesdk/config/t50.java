package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t50 extends SSettingKey<Boolean> {
    public static final t50 a = null;

    static {
        a = new t50();
    }

    public t50() {
        Boolean r1 = Boolean.FALSE;
        super("live_feedback_enable", "满意度轻交互功能开关", r1, r1);
    }
}
