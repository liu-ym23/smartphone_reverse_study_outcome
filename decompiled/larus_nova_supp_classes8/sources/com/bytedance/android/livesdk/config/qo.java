package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qo extends SSettingKey<Boolean> {
    public static final qo a = null;

    static {
        a = new qo();
    }

    public qo() {
        Boolean r1 = Boolean.FALSE;
        super("live_dispatcher_schema_test_toast_enable", "协议化调用开关的 toast", r1, r1);
    }
}
