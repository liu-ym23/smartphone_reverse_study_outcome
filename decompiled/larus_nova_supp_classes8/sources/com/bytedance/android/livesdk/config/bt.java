package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bt extends SSettingKey<Boolean> {
    public static final bt a = null;

    static {
        a = new bt();
    }

    public bt() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_setup_audio_push_stream", "音频链路合流优化开关", r1, r1);
    }
}
