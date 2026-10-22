package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g30 extends SettingKey<Boolean> {
    public static final g30 a = null;

    static {
        a = new g30();
    }

    public g30() {
        Boolean r4 = Boolean.TRUE;
        super("live_interact_tool_plugin_repel_refactor", "开播互动工具插件互斥逻辑重构", r4, r4, true);
    }
}
