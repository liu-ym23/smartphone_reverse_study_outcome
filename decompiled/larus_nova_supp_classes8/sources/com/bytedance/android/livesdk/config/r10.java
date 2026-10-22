package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r10 extends SSettingKey<Boolean> {
    public static final r10 a = null;

    static {
        a = new r10();
    }

    public r10() {
        Boolean r4 = Boolean.FALSE;
        super("live_inner_feed_pull_refresh_collect_unread_switch", "直播内流下拉刷新消重上报", r4, r4, true);
    }
}
