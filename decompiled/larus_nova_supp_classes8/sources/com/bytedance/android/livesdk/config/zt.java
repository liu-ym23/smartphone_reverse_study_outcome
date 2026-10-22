package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class zt extends SSettingKey<Boolean> {
    public static final zt a = null;

    static {
        a = new zt();
    }

    public zt() {
        Boolean r4 = Boolean.TRUE;
        super("live_end_page_security_log_fix", "关播页曝光埋点修正", r4, r4, false);
    }
}
