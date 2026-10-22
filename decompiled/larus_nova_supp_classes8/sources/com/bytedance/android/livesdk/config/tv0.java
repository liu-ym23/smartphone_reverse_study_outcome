package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class tv0 extends SSettingKey<Boolean> {
    public static final tv0 a = null;

    static {
        a = new tv0();
    }

    public tv0() {
        Boolean r1 = Boolean.TRUE;
        super("live_upload_alogger_check_issue", "是否允许集中上报日志查问题", r1, r1);
    }
}
