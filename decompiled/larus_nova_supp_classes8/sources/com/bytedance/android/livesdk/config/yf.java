package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class yf extends SSettingKey<Boolean> {
    public static final yf a = null;

    static {
        a = new yf();
    }

    public yf() {
        Boolean r1 = Boolean.FALSE;
        super("live_backend_memory_leak_fix", "backend框架内存泄漏修复及框架优化", r1, r1);
    }
}
