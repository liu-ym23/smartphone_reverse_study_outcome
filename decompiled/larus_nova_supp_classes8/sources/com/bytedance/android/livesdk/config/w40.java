package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w40 extends SSettingKey<Boolean> {
    public static final w40 a = null;

    static {
        a = new w40();
    }

    public w40() {
        Boolean r1 = Boolean.TRUE;
        super("live_ktv_order_song_panel_enable", "控制特定 app 是否支持打开点歌面板", r1, r1);
    }
}
