package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lx extends SSettingKey<Boolean> {
    public static final lx a = null;

    static {
        a = new lx();
    }

    public lx() {
        Boolean r4 = Boolean.TRUE;
        super("live_follow_log_enable", "关注Log上报开关", r4, r4, true);
    }
}
