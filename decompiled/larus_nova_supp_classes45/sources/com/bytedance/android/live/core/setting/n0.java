package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n0 extends SSettingKey<Boolean> {
    public static final n0 a = null;

    static {
        a = new n0();
    }

    public n0() {
        Boolean r1 = Boolean.TRUE;
        super("live_dsl_new_lynx_air_no_js", "新版去js的LynxAir", r1, r1);
    }
}
