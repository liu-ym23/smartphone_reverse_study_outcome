package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c4 extends SSettingKey<Boolean> {
    public static final c4 a = null;

    static {
        a = new c4();
    }

    public c4() {
        Boolean r1 = Boolean.TRUE;
        super("enable_pb_prefetch_shrink", "启用 Protobuf Prefetch", r1, r1);
    }
}
