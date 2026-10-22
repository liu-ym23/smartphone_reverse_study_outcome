package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wu0 extends SSettingKey<List<? extends String>> {
    public static final wu0 a = null;

    static {
        a = new wu0();
    }

    public wu0() {
        super("live_toolbar_chache_black_list", "Toolbarwidget view cache blacklist", new ArrayList(), new ArrayList());
    }
}
