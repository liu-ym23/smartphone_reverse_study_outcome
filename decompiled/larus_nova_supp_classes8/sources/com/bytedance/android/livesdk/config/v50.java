package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v50 extends SSettingKey<Boolean> {
    public static final v50 a = null;

    static {
        a = new v50();
    }

    public v50() {
        Boolean r1 = Boolean.FALSE;
        super("live_like_mem_fix", "点赞大对象问题修复", r1, r1);
    }
}
