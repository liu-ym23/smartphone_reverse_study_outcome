package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nr0 extends SSettingKey<Boolean> {
    public static final nr0 a = null;

    static {
        a = new nr0();
    }

    public nr0() {
        Boolean r1 = Boolean.TRUE;
        super("live_session_log", "行为分析埋点", r1, r1);
    }
}
