package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class js extends SSettingKey<Boolean> {
    public static final js a = null;

    static {
        a = new js();
    }

    public js() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_multi_link_server_mix_sr", "多人场景服务端合流超分", r1, r1);
    }
}
