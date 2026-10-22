package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xm0 extends SSettingKey<Boolean> {
    public static final xm0 a = null;

    static {
        a = new xm0();
    }

    public xm0() {
        Boolean r4 = Boolean.FALSE;
        super("live_report_crash_when_crash", "crash时上报退房信息", r4, r4, true);
    }
}
