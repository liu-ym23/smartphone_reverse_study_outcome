package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dm extends SSettingKey<Boolean> {
    public static final dm a = null;

    static {
        a = new dm();
    }

    public dm() {
        Boolean r1 = Boolean.FALSE;
        super("live_client_mix_stream", "端上配置是否客户端合流", r1, r1);
    }
}
