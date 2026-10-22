package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hj0 extends SSettingKey<Boolean> {
    public static final hj0 a = null;

    static {
        a = new hj0();
    }

    public hj0() {
        Boolean r1 = Boolean.TRUE;
        super("live_prefetch_support_async_callback", "prefetch支持异步回掉", r1, r1);
    }
}
