package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends SSettingKey<Boolean> {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
        Boolean r4 = Boolean.FALSE;
        super("enable_live_banner_resue", "banner复用开关", r4, r4, true);
    }
}
