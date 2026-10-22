package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b80 extends SettingKey<Boolean> {
    public static final b80 a = null;

    static {
        a = new b80();
    }

    public b80() {
        Boolean r1 = Boolean.FALSE;
        super("live_mdns_monitor_localip", "mdns trace 上报局域网ip", r1, r1);
    }
}
