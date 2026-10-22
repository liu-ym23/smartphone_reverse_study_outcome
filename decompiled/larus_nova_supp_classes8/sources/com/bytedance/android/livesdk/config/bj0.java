package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bj0 extends SettingKey<Boolean> {
    public static final bj0 a = null;

    static {
        a = new bj0();
    }

    public bj0() {
        Boolean r1 = Boolean.FALSE;
        super("live_popup_support_sticky", "面板降级支持sticky", r1, r1);
    }
}
