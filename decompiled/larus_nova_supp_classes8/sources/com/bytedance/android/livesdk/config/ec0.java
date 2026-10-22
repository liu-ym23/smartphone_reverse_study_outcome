package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ec0 extends SSettingKey<Boolean> {
    public static final ec0 a = null;

    static {
        a = new ec0();
    }

    public ec0() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_pub_stream_fall_back_protect", "跨房厅战公共流回退到跨房流后，首帧回调到来不再mute跨房流", r1, r1);
    }
}
