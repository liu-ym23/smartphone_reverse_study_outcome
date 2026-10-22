package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ym0 extends SettingKey<Boolean> {
    public static final ym0 a = null;

    static {
        a = new ym0();
    }

    public ym0() {
        Boolean r1 = Boolean.FALSE;
        super("live_request_gson_adapter_switch", "直播中请求独立gson解析器配置", r1, r1);
    }
}
