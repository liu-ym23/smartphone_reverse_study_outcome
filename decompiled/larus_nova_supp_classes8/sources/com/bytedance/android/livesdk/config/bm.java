package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bm extends SSettingKey<Boolean> {
    public static final bm a = null;

    static {
        a = new bm();
    }

    public bm() {
        Boolean r1 = Boolean.TRUE;
        super("live_context_fill_feed_room", "Context填充feedRoom", r1, r1);
    }
}
