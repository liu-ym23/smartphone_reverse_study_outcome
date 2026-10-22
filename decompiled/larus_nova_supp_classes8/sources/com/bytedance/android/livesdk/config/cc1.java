package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class cc1 extends SSettingKey<List<? extends String>> {
    public static final cc1 a = null;

    static {
        a = new cc1();
    }

    public cc1() {
        super("net_monitor_black_list", "网络错误监控黑名单", new ArrayList(), new ArrayList());
    }
}
