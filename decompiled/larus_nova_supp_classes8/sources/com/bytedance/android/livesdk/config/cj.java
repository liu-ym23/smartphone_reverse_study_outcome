package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class cj extends SSettingKey<Boolean> {
    public static final cj a = null;

    static {
        a = new cj();
    }

    public cj() {
        Boolean r1 = Boolean.TRUE;
        super("bytelink_uplink_api_switch", "直播Bytelink请求代理配置总开关", r1, r1);
    }
}
