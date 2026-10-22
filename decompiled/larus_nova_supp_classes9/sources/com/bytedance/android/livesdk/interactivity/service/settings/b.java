package com.bytedance.android.livesdk.interactivity.service.settings;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends SettingKey<Boolean> {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
        Boolean r1 = Boolean.TRUE;
        super("live_interactivity_degrade_by_audience_exp", "互动降级触发源为竖屏看播体验优化", r1, r1);
    }
}
