package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dp extends SSettingKey<List<? extends String>> {
    public static final dp a = null;

    static {
        a = new dp();
    }

    public dp() {
        super("live_drawer_multi_tab_config", "支持多Tab", new ArrayList(), new ArrayList());
    }
}
