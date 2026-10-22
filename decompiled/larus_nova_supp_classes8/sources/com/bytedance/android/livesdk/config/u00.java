package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u00 extends SSettingKey<Boolean> {
    public static final u00 a = null;

    static {
        a = new u00();
    }

    public u00() {
        Boolean r1 = Boolean.FALSE;
        super("live_hybrid_tryfix_fetch_v3_status_code", "修复fetch方法返回值没有statusCode", r1, r1);
    }
}
