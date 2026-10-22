package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dl0 extends SettingKey<Boolean> {
    public static final dl0 a = null;

    static {
        a = new dl0();
    }

    public dl0() {
        Boolean r1 = Boolean.FALSE;
        super("live_ps_use_backend_top_message", "公屏使用backend下发置顶消息", r1, r1);
    }
}
