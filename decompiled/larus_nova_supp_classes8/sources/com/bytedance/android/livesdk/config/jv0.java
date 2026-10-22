package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jv0 extends SSettingKey<Boolean> {
    public static final jv0 a = null;

    static {
        a = new jv0();
    }

    public jv0() {
        Boolean r1 = Boolean.FALSE;
        super("live_translucent_renderthread_opt", "透明引起RT冗余渲染优化", r1, r1);
    }
}
