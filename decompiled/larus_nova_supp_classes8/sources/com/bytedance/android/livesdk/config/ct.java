package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ct extends SSettingKey<Boolean> {
    public static final ct a = null;

    static {
        a = new ct();
    }

    public ct() {
        Boolean r4 = Boolean.TRUE;
        super("live_enable_shorttouch_term_strategy", "短触临态策略展示开关", r4, r4, false);
    }
}
