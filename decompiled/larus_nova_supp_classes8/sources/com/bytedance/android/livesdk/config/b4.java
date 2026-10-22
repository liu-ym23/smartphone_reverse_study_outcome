package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b4 extends SSettingKey<Boolean> {
    public static final b4 a = null;

    static {
        a = new b4();
    }

    public b4() {
        Boolean r1 = Boolean.TRUE;
        super("enable_pb_prefetch", "启用 Protobuf Prefetch", r1, r1);
    }
}
