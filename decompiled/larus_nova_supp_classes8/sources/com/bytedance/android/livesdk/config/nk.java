package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nk extends SSettingKey<Boolean> {
    public static final nk a = null;

    static {
        a = new nk();
    }

    public nk() {
        Boolean r1 = Boolean.FALSE;
        super("live_backend_chunk_enable", "backend数据分段返回", r1, r1);
    }
}
