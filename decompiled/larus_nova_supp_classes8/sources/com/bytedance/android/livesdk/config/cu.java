package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class cu extends SSettingKey<Boolean> {
    public static final cu a = null;

    static {
        a = new cu();
    }

    public cu() {
        Boolean r1 = Boolean.TRUE;
        super("live_enter_audio_room_first_frame_event_fallback", "语音场景进房首帧未上报兜底开关", r1, r1);
    }
}
