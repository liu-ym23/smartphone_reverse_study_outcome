package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hx0 extends SSettingKey<Integer> {
    public static final hx0 a = null;

    public hx0() {
        super("live_vip_im_api_frequency", "金主IM接口调用频控限制，单位 min", 5, 5);
    }

    static {
        a = new hx0();
    }
}
