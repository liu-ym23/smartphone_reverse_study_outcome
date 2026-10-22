package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xg0 extends SSettingKey<Boolean> {
    public static final xg0 a = null;

    static {
        a = new xg0();
    }

    public xg0() {
        Boolean r1 = Boolean.TRUE;
        super("live_pk_audience_reset_by_pull_state_enable", "观众端依赖拉流时机触发状态重置", r1, r1);
    }
}
