package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class kj extends SSettingKey<Boolean> {
    public static final kj a = null;

    static {
        a = new kj();
    }

    public kj() {
        Boolean r1 = Boolean.TRUE;
        super("live_cast_screen_paid_room_opt", "投屏直播间加密流适配", r1, r1);
    }
}
