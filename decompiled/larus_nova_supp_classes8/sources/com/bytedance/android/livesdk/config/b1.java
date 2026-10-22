package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b1 extends SSettingKey<List<? extends String>> {
    public static final b1 a = null;

    static {
        a = new b1();
    }

    public b1() {
        super(LiveInitSettingKeys.CJ_SCHEMA_RISK_INFO_HOSTS, "财经拼接risk_info支持的host", new ArrayList(), new ArrayList());
    }
}
