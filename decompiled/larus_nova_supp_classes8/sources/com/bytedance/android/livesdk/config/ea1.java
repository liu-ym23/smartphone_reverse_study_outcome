package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ea1 extends SSettingKey<Boolean> {
    public static final ea1 a = null;

    static {
        a = new ea1();
    }

    public ea1() {
        Boolean r1 = Boolean.TRUE;
        super("multi_anchor_enable_feedback_dialog", "主播连线开启feedback", r1, r1);
    }
}
