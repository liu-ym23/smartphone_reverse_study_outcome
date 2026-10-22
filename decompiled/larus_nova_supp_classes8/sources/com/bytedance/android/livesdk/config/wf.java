package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wf extends SSettingKey<Boolean> {
    public static final wf a = null;

    static {
        a = new wf();
    }

    public wf() {
        Boolean r1 = Boolean.TRUE;
        super("live_backend_fail_fix", "backend数据异常处理", r1, r1);
    }
}
