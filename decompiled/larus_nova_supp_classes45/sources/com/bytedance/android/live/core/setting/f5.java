package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f5 extends SSettingKey<Boolean> {
    public static final f5 a = null;

    static {
        a = new f5();
    }

    public f5() {
        Boolean r1 = Boolean.TRUE;
        super("live_short_touch_lynx_new_init_style", "短触区lynx使用新的初始化方式", r1, r1);
    }
}
