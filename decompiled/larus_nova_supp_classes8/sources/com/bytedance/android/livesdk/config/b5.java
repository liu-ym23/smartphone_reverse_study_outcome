package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b5 extends SSettingKey<Boolean> {
    public static final b5 a = null;

    static {
        a = new b5();
    }

    public b5() {
        Boolean r4 = Boolean.TRUE;
        super("fix_live_inner_leak_gray_config", "修复rx内存泄漏问题", r4, r4, true);
    }
}
