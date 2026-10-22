package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m6 extends SSettingKey<Boolean> {
    public static final m6 a = null;

    static {
        a = new m6();
    }

    public m6() {
        Boolean r1 = Boolean.TRUE;
        super("multi_anchor_sei_fix", "多人主播连线 sei首帧修复", r1, r1);
    }
}
