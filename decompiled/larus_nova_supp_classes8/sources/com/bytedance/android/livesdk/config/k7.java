package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k7 extends SSettingKey<Boolean> {
    public static final k7 a = null;

    static {
        a = new k7();
    }

    public k7() {
        Boolean r1 = Boolean.TRUE;
        super("hybrid_disable_super_kv", "hybrid 模块禁用 superkv", r1, r1);
    }
}
