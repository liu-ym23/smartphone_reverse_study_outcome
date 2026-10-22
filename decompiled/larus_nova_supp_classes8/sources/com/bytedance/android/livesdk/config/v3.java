package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v3 extends SSettingKey<Boolean> {
    public static final v3 a = null;

    static {
        a = new v3();
    }

    public v3() {
        Boolean r1 = Boolean.TRUE;
        super("enable_lynx_real_share_group", "真正开启Lynx共享Runtime", r1, r1);
    }
}
