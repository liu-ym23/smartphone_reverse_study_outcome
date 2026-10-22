package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class eq extends SettingKey<Boolean> {
    public static final eq a = null;

    static {
        a = new eq();
    }

    public eq() {
        Boolean r1 = Boolean.FALSE;
        super("has_ecom_live_desktop_guide", "电商直播间添加桌面系统——直播间内入口开关", r1, r1);
    }
}
