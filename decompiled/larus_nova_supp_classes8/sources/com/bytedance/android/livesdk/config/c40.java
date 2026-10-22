package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c40 extends SettingKey<Boolean> {
    public static final c40 a = null;

    static {
        a = new c40();
    }

    public c40() {
        Boolean r1 = Boolean.FALSE;
        super("live_ksong_public_screen_adjust", "ksong 公屏调整逻辑短路", r1, r1);
    }
}
