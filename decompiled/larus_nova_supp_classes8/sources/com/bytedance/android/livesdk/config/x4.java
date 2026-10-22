package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x4 extends SSettingKey<Boolean> {
    public static final x4 a = null;

    static {
        a = new x4();
    }

    public x4() {
        Boolean r4 = Boolean.TRUE;
        super("fix_destroy_live_play_heap_leak_opt", "解决退房拦截造成的泄漏问题", r4, r4, true);
    }
}
