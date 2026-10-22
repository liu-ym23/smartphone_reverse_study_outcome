package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ko extends SSettingKey<Boolean> {
    public static final ko a = null;

    static {
        a = new ko();
    }

    public ko() {
        Boolean r1 = Boolean.TRUE;
        super("live_disable_old_container_welfare", "公益组件是否下线直播老容器", r1, r1);
    }
}
