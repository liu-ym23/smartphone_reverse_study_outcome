package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class cn0 extends SSettingKey<Boolean> {
    public static final cn0 a = null;

    static {
        a = new cn0();
    }

    public cn0() {
        Boolean r4 = Boolean.TRUE;
        super("live_restart_live_when_login_protect", "直播间内登录触发重新进房兜底开关", r4, r4, true);
    }
}
