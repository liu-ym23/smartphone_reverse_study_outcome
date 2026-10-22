package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class yj1 extends SSettingKey<Boolean> {
    public static final yj1 a = null;

    static {
        a = new yj1();
    }

    public yj1() {
        Boolean r1 = Boolean.FALSE;
        super("ws_timeout_debug_enable", "消息长连超时调试开关", r1, r1);
    }
}
