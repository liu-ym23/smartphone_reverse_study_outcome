package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class io extends SSettingKey<Boolean> {
    public static final io a = null;

    static {
        a = new io();
    }

    public io() {
        Boolean r1 = Boolean.TRUE;
        super("live_disable_old_container_task_packet", "任务红包是否下线直播老容器", r1, r1);
    }
}
