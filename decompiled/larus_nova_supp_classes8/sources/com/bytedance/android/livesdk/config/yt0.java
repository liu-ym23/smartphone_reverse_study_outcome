package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class yt0 extends SettingKey<Boolean> {
    public static final yt0 a = null;

    static {
        a = new yt0();
    }

    public yt0() {
        Boolean r4 = Boolean.FALSE;
        super("live_surface_view_frame_cache", "", r4, r4, false);
    }
}
