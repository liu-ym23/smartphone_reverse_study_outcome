package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s3 extends SSettingKey<Boolean> {
    public static final s3 a = null;

    static {
        a = new s3();
    }

    public s3() {
        Boolean r1 = Boolean.TRUE;
        super("live_pk_crop_data_fix", "修复PC竖屏开播 PK退出后画面异常", r1, r1);
    }
}
