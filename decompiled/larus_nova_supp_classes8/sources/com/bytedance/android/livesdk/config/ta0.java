package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ta0 extends SSettingKey<Boolean> {
    public static final ta0 a = null;

    static {
        a = new ta0();
    }

    public ta0() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_audio_pub_stream_fall_back_protect", "【语音】跨房厅战公共流回退到跨房流后，首帧回调到来不再mute跨房流", r1, r1);
    }
}
