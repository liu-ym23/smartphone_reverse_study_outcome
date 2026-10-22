package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l7 extends SSettingKey<Boolean> {
    public static final l7 a = null;

    static {
        a = new l7();
    }

    public l7() {
        Boolean r1 = Boolean.TRUE;
        super("hybrid_prefetch_enabled", "Prefetch 开关", r1, r1);
    }
}
