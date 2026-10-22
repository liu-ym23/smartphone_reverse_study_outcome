package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class aa0 extends SettingKey<Boolean> {
    public static final aa0 a = null;

    static {
        a = new aa0();
    }

    public aa0() {
        Boolean r1 = Boolean.FALSE;
        super("live_more_dialog_capture_icon_show_enable", "更多面板是否展示摄像头开关", r1, r1);
    }
}
