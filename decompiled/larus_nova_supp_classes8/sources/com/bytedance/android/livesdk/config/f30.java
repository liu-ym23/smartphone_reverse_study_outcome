package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f30 extends SettingKey<Boolean> {
    public static final f30 a = null;

    static {
        a = new f30();
    }

    public f30() {
        Boolean r1 = Boolean.TRUE;
        super("live_interact_tool_enable_debug_mode", "开播互动工具支持debug模式", r1, r1);
    }
}
