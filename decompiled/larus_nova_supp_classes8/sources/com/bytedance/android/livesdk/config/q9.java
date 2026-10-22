package com.bytedance.android.livesdk.config;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q9 extends SSettingKey<Map<String, ? extends String>> {
    public static final q9 a = null;

    static {
        a = new q9();
    }

    public q9() {
        super("live_accurate_experiment_mapper", "精准实验key映射", new LinkedHashMap(), new LinkedHashMap());
    }
}
