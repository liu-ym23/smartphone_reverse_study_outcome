package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class oa1 extends SSettingKey<Boolean> {
    public static final oa1 a = null;

    static {
        a = new oa1();
    }

    public oa1() {
        Boolean r1 = Boolean.TRUE;
        super("multi_link_dynamic_context_fix", "动态化DynamicContext抢占兜底修复", r1, r1);
    }
}
