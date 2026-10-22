package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t60 extends SSettingKey<Boolean> {
    public static final t60 a = null;

    static {
        a = new t60();
    }

    public t60() {
        Boolean r1 = Boolean.FALSE;
        super("live_link_sdk_enable_frame_buffer_pool", "LiveLinkSDK开启FrameBuffer池", r1, r1);
    }
}
