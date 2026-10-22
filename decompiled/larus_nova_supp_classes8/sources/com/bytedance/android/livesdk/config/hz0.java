package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hz0 extends SSettingKey<Boolean> {
    public static final hz0 a = null;

    static {
        a = new hz0();
    }

    public hz0() {
        Boolean r1 = Boolean.FALSE;
        super("live_ws_frontier_url_replace", "直播长连替换成FrontierUrl", r1, r1);
    }
}
