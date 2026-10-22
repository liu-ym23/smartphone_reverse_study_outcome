package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k6 extends SSettingKey<Boolean> {
    public static final k6 a = null;

    static {
        a = new k6();
    }

    public k6() {
        Boolean r1 = Boolean.TRUE;
        super("live_widget_callback_leak_fix", "widgetCallback内存泄漏修改", r1, r1);
    }
}
