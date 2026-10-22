package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r70 extends SSettingKey<List<? extends String>> {
    public static final r70 a = null;

    static {
        a = new r70();
    }

    public r70() {
        super("live_lynx_online_fallback_path_list", "Lynx非离线化时走fallback逻辑", new ArrayList(), new ArrayList());
    }
}
