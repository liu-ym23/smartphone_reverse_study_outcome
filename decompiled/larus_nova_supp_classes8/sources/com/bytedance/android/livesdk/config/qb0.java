package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qb0 extends SSettingKey<Boolean> {
    public static final qb0 a = null;

    static {
        a = new qb0();
    }

    public qb0() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_link_pre_apply_enable", "观众预申请全量开关", r1, r1);
    }
}
