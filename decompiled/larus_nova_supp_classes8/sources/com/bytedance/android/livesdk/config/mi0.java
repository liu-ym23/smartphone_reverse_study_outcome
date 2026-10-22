package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mi0 extends SSettingKey<Boolean> {
    public static final mi0 a = null;

    static {
        a = new mi0();
    }

    public mi0() {
        Boolean r1 = Boolean.TRUE;
        super(LiveInitSettingKeys.LIVE_PLAYER_STRATEGY_SERVICE_SWITCH, "直播播放器策略服务开关", r1, r1);
    }
}
