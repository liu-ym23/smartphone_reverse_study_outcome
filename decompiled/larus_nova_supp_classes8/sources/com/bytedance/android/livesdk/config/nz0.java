package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nz0 extends SSettingKey<Boolean> {
    public static final nz0 a = null;

    static {
        a = new nz0();
    }

    public nz0() {
        Boolean r1 = Boolean.FALSE;
        super("live_xplay_audience_wtn_pull_stream_enable", "Xplay观众侧启动wtn拉流开关", r1, r1);
    }
}
