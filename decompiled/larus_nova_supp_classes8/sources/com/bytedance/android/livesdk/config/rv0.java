package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class rv0 extends SSettingKey<Boolean> {
    public static final rv0 a = null;

    static {
        a = new rv0();
    }

    public rv0() {
        Boolean r1 = Boolean.TRUE;
        super("live_unify_message_with_platform", "是否支持平台化统一通道", r1, r1);
    }
}
