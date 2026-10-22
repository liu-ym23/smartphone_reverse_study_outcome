package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xf extends SSettingKey<Boolean> {
    public static final xf a = null;

    static {
        a = new xf();
    }

    public xf() {
        Boolean r1 = Boolean.TRUE;
        super("live_backend_fix", "backend数据错位修复", r1, r1);
    }
}
