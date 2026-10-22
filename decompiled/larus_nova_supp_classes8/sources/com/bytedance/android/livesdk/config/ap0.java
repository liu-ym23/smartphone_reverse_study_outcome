package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ap0 extends SSettingKey<Boolean> {
    public static final ap0 a = null;

    static {
        a = new ap0();
    }

    public ap0() {
        Boolean r1 = Boolean.TRUE;
        super("live_room_params_transfer", "进房参数传递通用方案", r1, r1);
    }
}
