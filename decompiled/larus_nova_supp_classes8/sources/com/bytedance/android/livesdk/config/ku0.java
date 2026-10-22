package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ku0 extends SSettingKey<Boolean> {
    public static final ku0 a = null;

    static {
        a = new ku0();
    }

    public ku0() {
        Boolean r1 = Boolean.TRUE;
        super("live_talk_roomt_enable_restrat_audio_capture_when_resume", "是否在退后台返回前台的时候重启audiocatpure", r1, r1);
    }
}
