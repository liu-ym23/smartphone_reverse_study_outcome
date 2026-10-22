package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q40 extends SSettingKey<Long> {
    public static final q40 a = null;

    static {
        a = new q40();
    }

    public q40() {
        super("live_ktv_midi_lyric_load_time_out_duration", "KTV歌词和midi加载超时时长 (单位 ms)", 5000L, 5000L);
    }
}
