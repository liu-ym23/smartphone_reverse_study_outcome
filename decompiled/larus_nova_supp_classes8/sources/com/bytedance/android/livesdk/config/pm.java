package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pm extends SSettingKey<Boolean> {
    public static final pm a = null;

    static {
        a = new pm();
    }

    public pm() {
        Boolean r1 = Boolean.TRUE;
        super("live_current_streamer_room", "使用streamer room", r1, r1);
    }
}
