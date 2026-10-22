package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wh extends SSettingKey<Boolean> {
    public static final wh a = null;

    static {
        a = new wh();
    }

    public wh() {
        Boolean r1 = Boolean.FALSE;
        super("live_broadcast_restart_observer_memory", "开播重启监控低内存", r1, r1);
    }
}
