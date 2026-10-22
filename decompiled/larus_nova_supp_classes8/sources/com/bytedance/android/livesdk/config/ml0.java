package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ml0 extends SettingKey<Boolean> {
    public static final ml0 a = null;

    static {
        a = new ml0();
    }

    public ml0() {
        Boolean r1 = Boolean.FALSE;
        super("live_use_relax_feedback_public_screen", "满意度公屏Relax启用", r1, r1);
    }
}
