package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jo extends SSettingKey<Boolean> {
    public static final jo a = null;

    static {
        a = new jo();
    }

    public jo() {
        Boolean r1 = Boolean.TRUE;
        super("live_disable_old_container_test", "测试页面是否下线直播老容器", r1, r1);
    }
}
