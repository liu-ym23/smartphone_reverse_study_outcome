package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ws extends SSettingKey<Boolean> {
    public static final ws a = null;

    static {
        a = new ws();
    }

    public ws() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_schema_pre_reqeust", "schema进房请求流数据", r1, r1);
    }
}
