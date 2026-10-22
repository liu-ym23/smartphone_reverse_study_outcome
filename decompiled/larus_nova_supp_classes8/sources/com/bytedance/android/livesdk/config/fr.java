package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fr extends SSettingKey<Integer> {
    public static final fr a = null;

    public fr() {
        super("live_enable_cache_net_params", "是否开启网络参数缓存, 0表示不开启, >0表示缓存时间", 0, 0);
    }

    static {
        a = new fr();
    }
}
