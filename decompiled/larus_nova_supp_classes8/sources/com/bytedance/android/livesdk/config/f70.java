package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f70 extends SSettingKey<am2.v> {
    public static final f70 a = null;

    static {
        a = new f70();
    }

    public f70() {
        Object r0 = bi1.a(Boolean.valueOf(com.bytedance.android.live.core.utils.v.a()), am2.v.f());
        Object r4 = new am2.v();
        if (r0 == null) goto L6;
        r4 = r0;
    L6:
        super(LiveInitSettingKeys.LIVE_LOGSDK_CONFIG, am2.v.class, "日志sdk开关配置", r4, am2.v.e());
    }
}
