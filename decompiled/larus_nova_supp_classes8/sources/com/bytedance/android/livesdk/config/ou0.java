package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ou0 extends SettingKey<Integer> {
    public static final ou0 a = null;

    static {
        a = new ou0();
    }

    public ou0() {
        super("live_timebalance_log", "上报缩放比例", 100, 100);
    }
}
