package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ho extends SSettingKey<Boolean> {
    public static final ho a = null;

    static {
        a = new ho();
    }

    public ho() {
        Boolean r1 = Boolean.TRUE;
        super("live_disable_old_container_report", "report是否下线直播老容器", r1, r1);
    }
}
