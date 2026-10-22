package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c extends SSettingKey<Boolean> {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
        Boolean r1 = Boolean.FALSE;
        super("preload_lucky_ug_setting_ab", "不预初始化UGSettings", r1, r1);
    }
}
