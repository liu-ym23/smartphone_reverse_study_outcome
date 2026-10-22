package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a4 extends SSettingKey<Boolean> {
    public static final a4 a = null;

    static {
        a = new a4();
    }

    public a4() {
        Boolean r1 = Boolean.FALSE;
        super("live_sdk_preview_sr_support", "预览流是否支持超分", r1, r1);
    }
}
