package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n10 extends SSettingKey<List<? extends String>> {
    public static final n10 a = null;

    static {
        a = new n10();
    }

    public n10() {
        super("live_inner_feed_enable_pull_refresh", "直播间支持下拉刷新入口配置", new ArrayList(), new ArrayList());
    }
}
