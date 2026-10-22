package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d2 extends SSettingKey<Boolean> {
    public static final d2 a = null;

    static {
        a = new d2();
    }

    public d2() {
        Boolean r1 = Boolean.TRUE;
        super("live_jato_change_opt", "将 JatoOptFrameLayout 改为 VisibilityProxy 的端上兜底开关", r1, r1);
    }
}
