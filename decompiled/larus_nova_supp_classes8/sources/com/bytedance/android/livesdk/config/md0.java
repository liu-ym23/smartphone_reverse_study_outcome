package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class md0 extends SettingKey<Boolean> {
    public static final md0 a = null;

    static {
        a = new md0();
    }

    public md0() {
        Boolean r1 = Boolean.FALSE;
        super("live_nqe_common_params_build_opt", "nqe参数获取优化", r1, r1);
    }
}
