package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l2 extends SSettingKey<Boolean> {
    public static final l2 a = null;

    static {
        a = new l2();
    }

    public l2() {
        Boolean r1 = Boolean.FALSE;
        super("live_lynx_clear_scene_opt", "清屏模式lynx界面优化", r1, r1);
    }
}
