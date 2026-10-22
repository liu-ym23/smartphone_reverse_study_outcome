package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gc extends SettingKey<Boolean> {
    public static final gc a = null;

    static {
        a = new gc();
    }

    public gc() {
        super("live_anchor_new_more_panel", Boolean.TRUE, "新主播端更多面板");
    }
}
