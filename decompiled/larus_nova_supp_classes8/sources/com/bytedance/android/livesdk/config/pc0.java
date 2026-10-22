package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pc0 extends SSettingKey<Boolean> {
    public static final pc0 a = null;

    static {
        a = new pc0();
    }

    public pc0() {
        Boolean r1 = Boolean.FALSE;
        super("live_network_request_test_force_json", "强制 gift/list 使用 json", r1, r1);
    }
}
