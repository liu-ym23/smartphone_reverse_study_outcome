package com.bytedance.android.livesdk.interactivity.service.settings;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends SettingKey<Boolean> {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
        Boolean r1 = Boolean.TRUE;
        super("live_public_screen_bottom_touch_fix", "直播间公屏底部滑动优化", r1, r1);
    }
}
