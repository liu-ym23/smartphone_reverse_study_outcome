package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class cs extends SSettingKey<Boolean> {
    public static final cs a = null;

    static {
        a = new cs();
    }

    public cs() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_live_link_trace", "开启livelink trace", r1, r1);
    }
}
