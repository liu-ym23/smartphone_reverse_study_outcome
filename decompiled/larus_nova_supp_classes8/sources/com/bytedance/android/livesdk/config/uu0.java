package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class uu0 extends SettingKey<Boolean> {
    public static final uu0 a = null;

    static {
        a = new uu0();
    }

    public uu0() {
        Boolean r1 = Boolean.TRUE;
        super("live_toolbar_bubble_left_anchor_view_adapt", "直播间气泡适配左边锚地点", r1, r1);
    }
}
