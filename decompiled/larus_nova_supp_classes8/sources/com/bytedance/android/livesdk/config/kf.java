package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class kf extends SSettingKey<Boolean> {
    public static final kf a = null;

    static {
        a = new kf();
    }

    public kf() {
        Boolean r1 = Boolean.TRUE;
        super("live_audio_radio_chat_enable_preapply", "电台连线观众可申请连线按钮展示开关", r1, r1);
    }
}
