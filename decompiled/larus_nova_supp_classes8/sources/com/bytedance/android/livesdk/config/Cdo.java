package com.bytedance.android.livesdk.config;

/* JADX INFO: renamed from: com.bytedance.android.livesdk.config.do, reason: invalid class name */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class Cdo extends SSettingKey<Boolean> {
    public static final Cdo a = null;

    static {
        a = new Cdo();
    }

    public Cdo() {
        Boolean r1 = Boolean.TRUE;
        super("live_disable_old_container_fans_group", "粉丝团是否下线直播老容器", r1, r1);
    }
}
