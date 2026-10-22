package com.bytedance.android.livesdk.interactivity.service.settings;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends SettingKey<Boolean> {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
        Boolean r1 = Boolean.TRUE;
        super("live_public_area_badge_dsl_enable", "开启公屏Badge DSL", r1, r1);
    }
}
