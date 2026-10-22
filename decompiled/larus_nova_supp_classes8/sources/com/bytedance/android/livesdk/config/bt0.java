package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bt0 extends SSettingKey<Boolean> {
    public static final bt0 a = null;

    static {
        a = new bt0();
    }

    public bt0() {
        Boolean r1 = Boolean.TRUE;
        super("live_speech_lyric_recognize_ext_audio_input", "歌词识别使用外部源输入", r1, r1);
    }
}
