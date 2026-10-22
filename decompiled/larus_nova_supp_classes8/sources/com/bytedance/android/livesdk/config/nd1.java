package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nd1 extends SSettingKey<Boolean> {
    public static final nd1 a = null;

    static {
        a = new nd1();
    }

    public nd1() {
        Boolean r1 = Boolean.TRUE;
        super("pk_audience_mute_audio_in_beauty_dialog", "PK中嘉宾侧打开美颜面板时setAudioMute", r1, r1);
    }
}
