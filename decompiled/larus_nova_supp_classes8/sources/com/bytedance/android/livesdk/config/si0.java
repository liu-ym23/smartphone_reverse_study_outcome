package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class si0 extends SSettingKey<Boolean> {
    public static final si0 a = null;

    static {
        a = new si0();
    }

    public si0() {
        Boolean r4 = Boolean.FALSE;
        super("live_play_fragment_delay_init", "内流LivePlayFragment延迟预加载", r4, r4, true);
    }
}
