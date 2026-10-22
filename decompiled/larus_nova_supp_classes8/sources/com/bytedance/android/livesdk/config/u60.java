package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u60 extends SSettingKey<Boolean> {
    public static final u60 a = null;

    static {
        a = new u60();
    }

    public u60() {
        Boolean r1 = Boolean.FALSE;
        super("live_link_sdk_enable_texture_buffer_pool", "LiveLinkSDK开启Texture池", r1, r1);
    }
}
