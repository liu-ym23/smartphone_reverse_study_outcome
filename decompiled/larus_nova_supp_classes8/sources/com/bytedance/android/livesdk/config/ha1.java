package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ha1 extends SSettingKey<Boolean> {
    public static final ha1 a = null;

    static {
        a = new ha1();
    }

    public ha1() {
        Boolean r1 = Boolean.TRUE;
        super("multi_anchor_cache_list_opt_enable", "PK&主播连线cacheList在leave消息时不清理", r1, r1);
    }
}
