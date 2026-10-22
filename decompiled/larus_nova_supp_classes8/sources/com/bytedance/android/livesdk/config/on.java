package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class on extends SSettingKey<Boolean> {
    public static final on a = null;

    static {
        a = new on();
    }

    public on() {
        Boolean r1 = Boolean.TRUE;
        super("live_digg_no_recycle_local_bitmap", "点赞不主动回收本地bitmap", r1, r1);
    }
}
