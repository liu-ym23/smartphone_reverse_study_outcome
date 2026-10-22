package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ao0 extends SSettingKey<Boolean> {
    public static final ao0 a = null;

    static {
        a = new ao0();
    }

    public ao0() {
        Boolean r1 = Boolean.TRUE;
        super("live_room_close_jsb_enable", "是否支持通过JS关闭当前直播间", r1, r1);
    }
}
