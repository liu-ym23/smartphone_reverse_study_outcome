package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r81 extends SettingKey<Boolean> {
    public static final r81 a = null;

    static {
        a = new r81();
    }

    public r81() {
        Boolean r1 = Boolean.TRUE;
        super("live_tb_opt_view_cache", "toolbar架构优化view缓存", r1, r1);
    }
}
