package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class in0 extends SettingKey<Boolean> {
    public static final in0 a = null;

    static {
        a = new in0();
    }

    public in0() {
        Boolean r1 = Boolean.TRUE;
        super("live_revenue_protobuff_enable", "控制fetch是否开启protobuf", r1, r1);
    }
}
