package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fo extends SSettingKey<Boolean> {
    public static final fo a = null;

    static {
        a = new fo();
    }

    public fo() {
        Boolean r1 = Boolean.TRUE;
        super("live_disable_old_container_open_live_method", "OpenLiveMethod是否下线直播老容器", r1, r1);
    }
}
