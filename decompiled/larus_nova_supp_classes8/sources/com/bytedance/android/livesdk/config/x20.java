package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x20 extends SSettingKey<Boolean> {
    public static final x20 a = null;

    static {
        a = new x20();
    }

    public x20() {
        Boolean r1 = Boolean.FALSE;
        super("live_interact_play_storage_performance", "直播玩法性能采集开关", r1, r1);
    }
}
