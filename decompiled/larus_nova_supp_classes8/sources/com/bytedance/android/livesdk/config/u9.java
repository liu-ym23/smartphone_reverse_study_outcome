package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u9 extends SSettingKey<Boolean> {
    public static final u9 a = null;

    static {
        a = new u9();
    }

    public u9() {
        Boolean r1 = Boolean.FALSE;
        super("live_add_audio_metrics_model_enable", "音质打分能力开关", r1, r1);
    }
}
