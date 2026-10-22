package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class rr0 extends SettingKey<Boolean> {
    public static final rr0 a = null;

    static {
        a = new rr0();
    }

    public rr0() {
        Boolean r1 = Boolean.FALSE;
        super("live_setting_update_json_opt", "Setting更新时json转化优化", r1, r1);
    }
}
