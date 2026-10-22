package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p30 extends SSettingKey<Boolean> {
    public static final p30 a = null;

    static {
        a = new p30();
    }

    public p30() {
        Boolean r1 = Boolean.TRUE;
        super("live_io_async_init", "Live IO启用异步初始化", r1, r1);
    }
}
