package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wq0 extends SSettingKey<Boolean> {
    public static final wq0 a = null;

    static {
        a = new wq0();
    }

    public wq0() {
        Boolean r1 = Boolean.TRUE;
        super("live_sdk_cast_screen_gain_url_from_stream_info", "投屏url从streaminfo中获取", r1, r1);
    }
}
