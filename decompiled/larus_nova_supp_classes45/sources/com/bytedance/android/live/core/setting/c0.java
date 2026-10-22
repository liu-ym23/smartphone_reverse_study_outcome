package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c0 extends SSettingKey<Boolean> {
    public static final c0 a = null;

    static {
        a = new c0();
    }

    public c0() {
        Boolean r4 = Boolean.FALSE;
        super("live_close_widget_leak_opt", "RoomClose泄漏修改", r4, r4, false);
    }
}
