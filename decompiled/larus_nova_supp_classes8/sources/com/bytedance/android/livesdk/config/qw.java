package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qw extends SSettingKey<Boolean> {
    public static final qw a = null;

    static {
        a = new qw();
    }

    public qw() {
        Boolean r1 = Boolean.TRUE;
        super("live_fix_new_stream_ready_status_error", "修复音画链路ready的状态异常", r1, r1);
    }
}
