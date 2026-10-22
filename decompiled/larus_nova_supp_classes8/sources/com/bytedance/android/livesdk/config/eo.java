package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class eo extends SSettingKey<Boolean> {
    public static final eo a = null;

    static {
        a = new eo();
    }

    public eo() {
        Boolean r1 = Boolean.TRUE;
        super("live_disable_old_container_live", "直播间是否下线直播老容器", r1, r1);
    }
}
