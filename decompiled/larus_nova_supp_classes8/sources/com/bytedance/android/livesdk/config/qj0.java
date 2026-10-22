package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qj0 extends SSettingKey<Boolean> {
    public static final qj0 a = null;

    static {
        a = new qj0();
    }

    public qj0() {
        Boolean r1 = Boolean.TRUE;
        super("live_preview_fix_activity_leak_sdk", "sdk内存泄漏问题修复开关", r1, r1);
    }
}
