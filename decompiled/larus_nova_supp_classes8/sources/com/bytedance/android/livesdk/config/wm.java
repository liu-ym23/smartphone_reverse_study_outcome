package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wm extends SettingKey<Boolean> {
    public static final wm a = null;

    static {
        a = new wm();
    }

    public wm() {
        Boolean r1 = Boolean.FALSE;
        super("live_decoration_show_bug_fix", "修复直播间贴纸重复上屏", r1, r1);
    }
}
