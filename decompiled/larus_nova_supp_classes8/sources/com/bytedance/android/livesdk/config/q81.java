package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q81 extends SettingKey<Boolean> {
    public static final q81 a = null;

    static {
        a = new q81();
    }

    public q81() {
        Boolean r1 = Boolean.TRUE;
        super("live_tb_fix_add_view_error", "toolbar架构修复添加view出错", r1, r1);
    }
}
