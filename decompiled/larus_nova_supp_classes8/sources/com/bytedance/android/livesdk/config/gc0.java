package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gc0 extends SSettingKey<Boolean> {
    public static final gc0 a = null;

    static {
        a = new gc0();
    }

    public gc0() {
        Boolean r4 = Boolean.TRUE;
        super("live_multi_room_bugfix", "预加载直播间bugfix", r4, r4, true);
    }
}
