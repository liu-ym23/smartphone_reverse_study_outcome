package com.bytedance.android.livesdk.config;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pc extends SSettingKey<Map<String, ? extends String>> {
    public static final pc a = null;

    static {
        a = new pc();
    }

    public pc() {
        super("live_anchor_report_url_extra_schema_param", "举报主播schema额外参数", new LinkedHashMap(), new LinkedHashMap());
    }
}
