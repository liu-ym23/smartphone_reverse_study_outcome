package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mu extends SSettingKey<Boolean> {
    public static final mu a = null;

    static {
        a = new mu();
    }

    public mu() {
        Boolean r1 = Boolean.FALSE;
        super("live_enter_room_pre_pull_stream_switch", "直播间进房是否开启预拉流的开关", r1, r1);
    }
}
