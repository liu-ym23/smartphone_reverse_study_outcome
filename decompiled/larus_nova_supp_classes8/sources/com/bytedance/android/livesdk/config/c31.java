package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c31 extends SSettingKey<Boolean> {
    public static final c31 a = null;

    static {
        a = new c31();
    }

    public c31() {
        Boolean r1 = Boolean.TRUE;
        super("live_fix_pinch_no_move", "修复pinch放大模式双指点击只接收到down和up事件导致的异常bug", r1, r1);
    }
}
