package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gm extends SSettingKey<Boolean> {
    public static final gm a = null;

    static {
        a = new gm();
    }

    public gm() {
        Boolean r1 = Boolean.FALSE;
        super("live_core_async_logger_safe_quit", "LiveCore日志上报线程是否安全退出", r1, r1);
    }
}
