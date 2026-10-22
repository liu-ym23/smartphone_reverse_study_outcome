package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class rl0 extends SSettingKey<Boolean> {
    public static final rl0 a = null;

    static {
        a = new rl0();
    }

    public rl0() {
        Boolean r1 = Boolean.TRUE;
        super("live_public_screen_optimize_clear_pos", "公屏优化位置清理兜底开关", r1, r1);
    }
}
