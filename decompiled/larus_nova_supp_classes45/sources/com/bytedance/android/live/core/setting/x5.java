package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x5 extends SSettingKey<Boolean> {
    public static final x5 a = null;

    static {
        a = new x5();
    }

    public x5() {
        Boolean r1 = Boolean.TRUE;
        super("live_vs_fix_multi_camera_camera_ticket", "竖屏子机位打开主机位购票入口失败", r1, r1);
    }
}
