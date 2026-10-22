package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jx0 extends SettingKey<Boolean> {
    public static final jx0 a = null;

    static {
        a = new jx0();
    }

    public jx0() {
        Boolean r4 = Boolean.TRUE;
        super("live_virtual_live_jsb_manager_set_fix", "虚拟直播jsbManager异常设置修复", r4, r4, false);
    }
}
