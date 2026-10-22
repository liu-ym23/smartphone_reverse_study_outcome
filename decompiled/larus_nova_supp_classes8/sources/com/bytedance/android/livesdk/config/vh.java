package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vh extends SSettingKey<Boolean> {
    public static final vh a = null;

    static {
        a = new vh();
    }

    public vh() {
        Boolean r1 = Boolean.FALSE;
        super("live_broadcast_restart_enable", "开播重启功能", r1, r1);
    }
}
