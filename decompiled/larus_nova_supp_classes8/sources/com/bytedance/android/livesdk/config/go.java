package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class go extends SSettingKey<Boolean> {
    public static final go a = null;

    static {
        a = new go();
    }

    public go() {
        Boolean r1 = Boolean.TRUE;
        super("live_disable_old_container_preview", "预览流是否下线直播老容器", r1, r1);
    }
}
