package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k3 extends SSettingKey<Boolean> {
    public static final k3 a = null;

    static {
        a = new k3();
    }

    public k3() {
        Boolean r1 = Boolean.TRUE;
        super("enable_large_font_fix", "是否允许大字化适配", r1, r1);
    }
}
