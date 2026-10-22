package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t3 extends SSettingKey<Boolean> {
    public static final t3 a = null;

    static {
        a = new t3();
    }

    public t3() {
        Boolean r1 = Boolean.TRUE;
        super("enable_local_life_independent_module", "开启独立组件能力", r1, r1);
    }
}
