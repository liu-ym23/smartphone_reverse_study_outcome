package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nw extends SSettingKey<Boolean> {
    public static final nw a = null;

    static {
        a = new nw();
    }

    public nw() {
        Boolean r1 = Boolean.FALSE;
        super("live_fix_host_initialize_npe", "修复live初始化npe", r1, r1);
    }
}
