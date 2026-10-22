package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ia1 extends SSettingKey<Boolean> {
    public static final ia1 a = null;

    static {
        a = new ia1();
    }

    public ia1() {
        Boolean r1 = Boolean.FALSE;
        super("multi_anchor_debug_enable", "主播连线调试开关", r1, r1);
    }
}
