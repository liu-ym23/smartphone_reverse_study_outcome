package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ep extends SSettingKey<List<? extends String>> {
    public static final ep a = null;

    static {
        a = new ep();
    }

    public ep() {
        super("live_drawer_entrance_key", "抽屉入口", new ArrayList(), new ArrayList());
    }
}
