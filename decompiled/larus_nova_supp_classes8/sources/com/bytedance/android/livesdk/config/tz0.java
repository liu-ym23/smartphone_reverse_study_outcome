package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class tz0 extends SSettingKey<Boolean> {
    public static final tz0 a = null;

    static {
        a = new tz0();
    }

    public tz0() {
        Boolean r1 = Boolean.TRUE;
        super("live_xplay_pause_or_resume_game_switch", "主播退后台是否调用 pauseGame 开关", r1, r1);
    }
}
