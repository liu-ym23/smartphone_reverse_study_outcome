package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v30 extends SettingKey<Boolean> {
    public static final v30 a = null;

    static {
        a = new v30();
    }

    public v30() {
        Boolean r1 = Boolean.FALSE;
        super("live_jsb_gson_adapter_switch", "直播jsb中独立gson解析器配置", r1, r1);
    }
}
