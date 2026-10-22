package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b2 extends SSettingKey<Boolean> {
    public static final b2 a = null;

    static {
        a = new b2();
    }

    public b2() {
        super("debug_show_enter_key", Boolean.FALSE, "测试专用，进房弹出来源参数");
    }
}
