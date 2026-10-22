package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g80 extends SSettingKey<Boolean> {
    public static final g80 a = null;

    static {
        a = new g80();
    }

    public g80() {
        Boolean r1 = Boolean.TRUE;
        super("live_mem_leak_extra_render", "修复：副视图内存泄漏问题", r1, r1);
    }
}
