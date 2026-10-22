package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jm extends SSettingKey<Boolean> {
    public static final jm a = null;

    static {
        a = new jm();
    }

    public jm() {
        Boolean r1 = Boolean.TRUE;
        super("live_core_single_view_mode_for_anchor_stream_switch_enable", "重保场景是否支持开启单View模式", r1, r1);
    }
}
