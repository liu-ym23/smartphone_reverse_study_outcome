package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dz extends SettingKey<Boolean> {
    public static final dz a = null;

    static {
        a = new dz();
    }

    public dz() {
        super("live_gift_safely_init_model", "安全执行initmodel", Boolean.FALSE, Boolean.TRUE);
    }
}
