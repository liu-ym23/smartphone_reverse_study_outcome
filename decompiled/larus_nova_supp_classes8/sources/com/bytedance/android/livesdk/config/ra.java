package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ra extends SSettingKey<List<? extends String>> {
    public static final ra a = null;

    static {
        a = new ra();
    }

    public ra() {
        super("live_anchor_alog_intercept_list", "开播日志拦截列表", new ArrayList(), new ArrayList());
    }
}
