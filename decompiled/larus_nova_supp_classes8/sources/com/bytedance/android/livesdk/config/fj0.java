package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fj0 extends SSettingKey<Boolean> {
    public static final fj0 a = null;

    static {
        a = new fj0();
    }

    public fj0() {
        Boolean r1 = Boolean.FALSE;
        super("live_prefetch_avoid_thread_switching", "避免 prefetch 回调线程切换", r1, r1);
    }
}
