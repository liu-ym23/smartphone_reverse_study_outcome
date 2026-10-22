package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m0 extends SSettingKey<Boolean> {
    public static final m0 a = null;

    static {
        a = new m0();
    }

    public m0() {
        Boolean r1 = Boolean.FALSE;
        super("live_disable_find_diagnose_service", "是否允许查找C端诊断工具", r1, r1);
    }
}
