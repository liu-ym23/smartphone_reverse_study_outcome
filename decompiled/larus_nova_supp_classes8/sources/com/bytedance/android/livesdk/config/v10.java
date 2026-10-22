package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v10 extends SSettingKey<Boolean> {
    public static final v10 a = null;

    static {
        a = new v10();
    }

    public v10() {
        Boolean r4 = Boolean.TRUE;
        super("live_inner_feed_rerank_common_opt_enable", "直播内流重排逻辑开关", r4, r4, true);
    }
}
