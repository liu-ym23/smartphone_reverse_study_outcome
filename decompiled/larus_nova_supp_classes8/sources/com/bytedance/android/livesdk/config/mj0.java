package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mj0 extends SettingKey<Boolean> {
    public static final mj0 a = null;

    static {
        a = new mj0();
    }

    public mj0() {
        Boolean r1 = Boolean.TRUE;
        super("live_preview_daily_opt_enable", "开播页新增日常模式的端上兜底开关", r1, r1);
    }
}
