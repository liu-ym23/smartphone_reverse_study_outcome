package com.bytedance.android.live.misc;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends SSettingKey<Boolean> {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
        Boolean r1 = Boolean.FALSE;
        super("live_anchor_biz_panel_enable", "主播经营数据面板", r1, r1);
    }
}
