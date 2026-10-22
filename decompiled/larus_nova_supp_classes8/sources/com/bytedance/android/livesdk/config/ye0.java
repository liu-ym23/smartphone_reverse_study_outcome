package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ye0 extends SettingKey<Boolean> {
    public static final ye0 a = null;

    static {
        a = new ye0();
    }

    public ye0() {
        Boolean r1 = Boolean.TRUE;
        super("live_pad_clearscreen_close_adapter", "Pad清屏模式关闭按钮适配", r1, r1);
    }
}
