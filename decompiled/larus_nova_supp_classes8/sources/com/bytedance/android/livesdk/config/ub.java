package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ub extends SSettingKey<Boolean> {
    public static final ub a = null;

    static {
        a = new ub();
    }

    public ub() {
        Boolean r1 = Boolean.TRUE;
        super("live_anchor_fix_announcement_input_filter", "修复预告内容输入栏不适配手写输入的问题", r1, r1);
    }
}
