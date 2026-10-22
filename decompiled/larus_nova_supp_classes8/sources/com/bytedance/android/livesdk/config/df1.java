package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class df1 extends SSettingKey<Boolean> {
    public static final df1 a = null;

    static {
        a = new df1();
    }

    public df1() {
        Boolean r1 = Boolean.TRUE;
        super("live_core_reset_params_leave_channel", "下麦时重置LiveCore参数新方式", r1, r1);
    }
}
