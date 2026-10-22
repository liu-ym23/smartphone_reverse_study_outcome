package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class iv0 extends SettingKey<Boolean> {
    public static final iv0 a = null;

    static {
        a = new iv0();
    }

    public iv0() {
        Boolean r1 = Boolean.TRUE;
        super("LIVE_TRANSLATION_AND_SCALE_OPT", "横屏看播缩放大小适配", r1, r1);
    }
}
