package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dw0 extends SettingKey<Boolean> {
    public static final dw0 a = null;

    static {
        a = new dw0();
    }

    public dw0() {
        Boolean r1 = Boolean.TRUE;
        super("live_usercenter_monitor_hostuser", "是否监控UserCenter hostUser为null", r1, r1);
    }
}
