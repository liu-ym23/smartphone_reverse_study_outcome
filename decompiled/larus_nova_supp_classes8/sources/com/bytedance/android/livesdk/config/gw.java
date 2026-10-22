package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gw extends SSettingKey<Boolean> {
    public static final gw a = null;

    static {
        a = new gw();
    }

    public gw() {
        Boolean r4 = Boolean.FALSE;
        super("live_fix_crash_observer_leak", "crash时上报退房信息内存泄漏fix", r4, r4, true);
    }
}
