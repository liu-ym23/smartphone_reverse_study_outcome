package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dv0 extends SettingKey<Boolean> {
    public static final dv0 a = null;

    static {
        a = new dv0();
    }

    public dv0() {
        Boolean r1 = Boolean.TRUE;
        super("live_toolbar_memory_leak_fix", "toolbarManager 内存泄露修复", r1, r1);
    }
}
