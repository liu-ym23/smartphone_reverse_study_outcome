package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gh extends SSettingKey<Boolean> {
    public static final gh a = null;

    static {
        a = new gh();
    }

    public gh() {
        Boolean r1 = Boolean.FALSE;
        super("live_broadcast_log_opt", "开播日志上报优化", r1, r1);
    }
}
