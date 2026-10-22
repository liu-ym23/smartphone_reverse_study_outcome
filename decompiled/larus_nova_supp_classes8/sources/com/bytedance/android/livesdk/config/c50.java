package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c50 extends SSettingKey<Boolean> {
    public static final c50 a = null;

    static {
        a = new c50();
    }

    public c50() {
        Boolean r1 = Boolean.TRUE;
        super("live_ktv_setting_play_panel_enable", "语音ktv设置面板是否支持展示玩法入口", r1, r1);
    }
}
