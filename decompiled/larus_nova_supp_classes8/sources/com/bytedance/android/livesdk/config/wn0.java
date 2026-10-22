package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wn0 extends SSettingKey<Boolean> {
    public static final wn0 a = null;

    static {
        a = new wn0();
    }

    public wn0() {
        Boolean r1 = Boolean.TRUE;
        super("live_room_bcm_params_enable", "直播间内是否增加bcm页面参数", r1, r1);
    }
}
