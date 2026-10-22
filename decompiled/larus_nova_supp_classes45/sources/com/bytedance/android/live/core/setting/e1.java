package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e1 extends SSettingKey<Boolean> {
    public static final e1 a = null;

    static {
        a = new e1();
    }

    public e1() {
        Boolean r1 = Boolean.TRUE;
        super("webcast_banner_lynx_switch", "心愿单支持Lynx加载", r1, r1);
    }
}
