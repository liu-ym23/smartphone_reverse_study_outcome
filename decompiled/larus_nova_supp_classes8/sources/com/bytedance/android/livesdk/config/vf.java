package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vf extends SSettingKey<Boolean> {
    public static final vf a = null;

    static {
        a = new vf();
    }

    public vf() {
        Boolean r4 = Boolean.FALSE;
        super("live_backend_compatible_optimize", "backend所有业务兼容接入+分段优化", r4, r4, true);
    }
}
