package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class cw extends SSettingKey<Boolean> {
    public static final cw a = null;

    static {
        a = new cw();
    }

    public cw() {
        Boolean r1 = Boolean.FALSE;
        super("live_fix_activity_memory_config", "修复activity内存泄漏开关", r1, r1);
    }
}
