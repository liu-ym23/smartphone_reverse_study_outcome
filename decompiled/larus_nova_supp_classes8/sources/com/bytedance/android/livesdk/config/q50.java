package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q50 extends SSettingKey<Boolean> {
    public static final q50 a = null;

    static {
        a = new q50();
    }

    public q50() {
        Boolean r1 = Boolean.TRUE;
        super("live_latch_pre_start_init_annie", "latch 提前执行初始化 Annie", r1, r1);
    }
}
