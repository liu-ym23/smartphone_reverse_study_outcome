package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x3 extends SSettingKey<Boolean> {
    public static final x3 a = null;

    static {
        a = new x3();
    }

    public x3() {
        Boolean r1 = Boolean.TRUE;
        super("enable_lynx_user_feedback_in_live", "满意度反馈lynx方案", r1, r1);
    }
}
