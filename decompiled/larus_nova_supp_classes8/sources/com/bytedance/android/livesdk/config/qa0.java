package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qa0 extends SSettingKey<Boolean> {
    public static final qa0 a = null;

    static {
        a = new qa0();
    }

    public qa0() {
        Boolean r1 = Boolean.TRUE;
        super("live_multilink_fresco_cache_clear", "多人fresco私有缓存清理", r1, r1);
    }
}
