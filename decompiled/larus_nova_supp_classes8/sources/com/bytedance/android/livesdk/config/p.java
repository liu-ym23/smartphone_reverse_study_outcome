package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p extends SSettingKey<Boolean> {
    public static final p a = null;

    static {
        a = new p();
    }

    public p() {
        Boolean r1 = Boolean.TRUE;
        super("audience_cast_state_opt", "观众投屏状态处理优化 默认开启", r1, r1);
    }
}
