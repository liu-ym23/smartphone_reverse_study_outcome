package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class oi1 extends SSettingKey<Boolean> {
    public static final oi1 a = null;

    static {
        a = new oi1();
    }

    public oi1() {
        Boolean r1 = Boolean.TRUE;
        super("live_use_middle_logger", "修改logger方式", r1, r1);
    }
}
