package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jt extends SSettingKey<Boolean> {
    public static final jt a = null;

    static {
        a = new jt();
    }

    public jt() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_test_info_upload", "是否允许上报直播间测试信息", r1, r1);
    }
}
