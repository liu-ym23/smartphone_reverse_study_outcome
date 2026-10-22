package com.bytedance.android.live.core.setting;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j3 extends SettingKey<List<? extends String>> {
    public static final j3 a = null;

    static {
        a = new j3();
    }

    public j3() {
        super("live_offline_patterns", "离线拦截列表", new ArrayList(), new ArrayList());
    }
}
