package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ex extends SSettingKey<Boolean> {
    public static final ex a = null;

    static {
        a = new ex();
    }

    public ex() {
        Boolean r1 = Boolean.TRUE;
        super("live_float_window_traffic_gateway_enable", "直播小窗接入流量海关", r1, r1);
    }
}
