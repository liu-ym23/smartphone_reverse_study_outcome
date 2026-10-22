package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ls0 extends SSettingKey<Boolean> {
    public static final ls0 a = null;

    static {
        a = new ls0();
    }

    public ls0() {
        Boolean r1 = Boolean.FALSE;
        super("live_show_ai_mve_debug_view", "是否展示AI MV调试信息", r1, r1);
    }
}
