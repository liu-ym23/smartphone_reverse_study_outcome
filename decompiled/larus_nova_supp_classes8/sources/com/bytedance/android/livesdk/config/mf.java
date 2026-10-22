package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mf extends SSettingKey<Boolean> {
    public static final mf a = null;

    static {
        a = new mf();
    }

    public mf() {
        Boolean r1 = Boolean.TRUE;
        super("live_audio_subtitle_sei_check", "检查字幕sei是否符合json格式", r1, r1);
    }
}
