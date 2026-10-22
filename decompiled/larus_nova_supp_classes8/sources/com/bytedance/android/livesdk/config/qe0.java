package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qe0 extends SSettingKey<Boolean> {
    public static final qe0 a = null;

    static {
        a = new qe0();
    }

    public qe0() {
        Boolean r1 = Boolean.TRUE;
        super("live_opt_load_livecore_so", "是否开启livecore加载so加载流程优化", r1, r1);
    }
}
