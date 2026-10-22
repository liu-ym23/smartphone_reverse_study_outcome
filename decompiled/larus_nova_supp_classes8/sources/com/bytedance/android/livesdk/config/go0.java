package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class go0 extends SSettingKey<Boolean> {
    public static final go0 a = null;

    static {
        a = new go0();
    }

    public go0() {
        Boolean r4 = Boolean.TRUE;
        super("live_room_end_vip_enable", "直播间结束后用户等待优化功能开启", r4, r4, false);
    }
}
