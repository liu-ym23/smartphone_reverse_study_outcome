package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v60 extends SSettingKey<Boolean> {
    public static final v60 a = null;

    static {
        a = new v60();
    }

    public v60() {
        Boolean r1 = Boolean.TRUE;
        super("live_link_supported_force_server_mix", "多人场景是否支持强制服务端合流", r1, r1);
    }
}
